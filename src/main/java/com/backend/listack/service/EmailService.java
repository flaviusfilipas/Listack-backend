package com.backend.listack.service;

import com.backend.listack.dto.ContributorInvitationDTO;
import com.backend.listack.dto.UserDTO;
import com.backend.listack.enums.EmailTemplateType;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

@Service
@AllArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;
    private final UserService userService;
    private final ContributorInvitationService contributorInvitationService;

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
        mailSender.send(buildEmail(email, EmailTemplateType.CONFIRMATION_EMAIL_WITH_ACCOUNT,
                listId, userId, inviterName));
    }

    @SneakyThrows
    private void sendConfirmationEmailForUserWithNoAccount(String email, String inviterName, Integer listId) {
        mailSender.send(buildEmail(email, EmailTemplateType.CONFIRMATION_EMAIL_WITHOUT_ACCOUNT,
                listId, null, inviterName));
    }

    private MimeMessage buildEmail(String recipientEmail, EmailTemplateType emailType, Integer listId,
                                   String userId, String inviterName) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setFrom("listack@localhost.com");
        mimeMessageHelper.setSubject("Join shared shopping list");
        mimeMessageHelper.setTo(recipientEmail);
        mimeMessageHelper.setText(getEmailType(emailType, listId, userId, inviterName), true);
        return mimeMessage;
    }

    private String getEmailType(EmailTemplateType emailTemplateType, Integer listId, String userId, String inviterName) {
        final Context context = new Context();
        switch (emailTemplateType) {
            case CONFIRMATION_EMAIL_WITH_ACCOUNT:
                context.setVariable("listId", listId);
                context.setVariable("inviterName", inviterName);
                context.setVariable("userId", userId);
                break;
            case CONFIRMATION_EMAIL_WITHOUT_ACCOUNT:
                context.setVariable("listId", listId);
                context.setVariable("inviterName", inviterName);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + emailTemplateType);
        }

        return templateEngine.process(emailTemplateType.getValue(), context);
    }

}
