package com.backend.listack.service;

import com.backend.listack.dto.ContributorInvitationDTO;
import com.backend.listack.dto.UserDTO;
import com.backend.listack.enums.EmailTemplateType;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

import static com.backend.listack.enums.EmailTemplateType.CONFIRMATION_EMAIL_WITHOUT_ACCOUNT;
import static com.backend.listack.enums.EmailTemplateType.CONFIRMATION_EMAIL_WITH_ACCOUNT;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
public class EmailService {
    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;
    private final UserService userService;
    private final ContributorInvitationService contributorInvitationService;
    @Value("${email.from:}")
    private String senderEmailAddress;
    @Value("${email.subject:}")
    private String emailSubject;

    public EmailService(JavaMailSender mailSender, TemplateEngine templateEngine,
                        UserService userService, ContributorInvitationService contributorInvitationService) {
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
        this.userService = userService;
        this.contributorInvitationService = contributorInvitationService;
    }

    @PostConstruct
    public void initialize() {
        if(isBlank(senderEmailAddress)) {
            throw new IllegalArgumentException("Configuration for sending emails is wrong - sender email is blank");
        }
        if(isBlank(emailSubject)) {
            throw new IllegalArgumentException("Configuration for sending emails is wrong - email subject blank");
        }
    }

    public void sendContributorConfirmationEmail(String inviterName, List<ContributorInvitationDTO> pendingInvitations) {
        for (ContributorInvitationDTO contributorInvitationDTO : pendingInvitations) {
            String email=contributorInvitationDTO.getEmail();
            UserDTO user = userService.findByEmail(email);
            if (user != null) {
                sendConfirmationEmail(email, user.getId(), inviterName,
                        contributorInvitationDTO.getShoppingListId());
            } else {
                sendConfirmationEmailForUserWithNoAccount(email, inviterName,
                        contributorInvitationDTO.getShoppingListId());
            }
            contributorInvitationDTO.setSentEmail(true);
            contributorInvitationService.save(contributorInvitationDTO);
        }
    }

    @SneakyThrows
    private void sendConfirmationEmail(String email, String userId, String inviterName, Integer listId) {
        mailSender.send(buildEmail(email, CONFIRMATION_EMAIL_WITH_ACCOUNT,
                listId, userId, inviterName));
    }

    @SneakyThrows
    private void sendConfirmationEmailForUserWithNoAccount(String email, String inviterName, Integer listId) {
        mailSender.send(buildEmail(email, CONFIRMATION_EMAIL_WITHOUT_ACCOUNT,
                listId, null, inviterName));
    }

    private MimeMessage buildEmail(String recipientEmail, EmailTemplateType emailType, Integer listId,
                                   String userId, String inviterName) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setFrom(senderEmailAddress);
        mimeMessageHelper.setSubject(emailSubject);
        mimeMessageHelper.setTo(recipientEmail);
        mimeMessageHelper.setText(getEmailType(emailType, listId, userId, inviterName,recipientEmail), true);
        return mimeMessage;
    }

    private String getEmailType(EmailTemplateType emailTemplateType, Integer listId,
                                String userId, String inviterName, String recipientEmail) {
        final Context context = new Context();
        switch (emailTemplateType) {
            case CONFIRMATION_EMAIL_WITH_ACCOUNT:
                configureBaseContext(listId, inviterName, context);
                context.setVariable("userId", userId);
                break;
            case CONFIRMATION_EMAIL_WITHOUT_ACCOUNT:
                configureBaseContext(listId, inviterName, context);
                context.setVariable("recipientEmail", recipientEmail);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + emailTemplateType);
        }

        return templateEngine.process(emailTemplateType.getValue(), context);
    }

    private void configureBaseContext(Integer listId, String inviterName, Context context) {
        context.setVariable("listId", listId);
        context.setVariable("inviterName", inviterName);
    }
}
