package com.backend.listack.resource;

import com.backend.listack.dto.ContributorInvitationDTO;
import com.backend.listack.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/api/emails")
public class EmailResource {
    private final EmailService emailService;

    @PostMapping("/contributor/confirmation")
    public ResponseEntity<Void> sendConfirmationEmail(@RequestParam String inviterName,
                                                      @RequestBody List<ContributorInvitationDTO> pendingInvitations) {
        emailService.sendContributorConfirmationEmail(inviterName, pendingInvitations);
        return ResponseEntity.noContent().build();
    }
}
