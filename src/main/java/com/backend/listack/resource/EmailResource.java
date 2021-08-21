package com.backend.listack.resource;

import com.backend.listack.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/api/emails")
public class EmailResource {
    private final EmailService emailService;

    @PostMapping("/contributor/confirmation")
    public ResponseEntity<Void> sendConfirmationEmail(@RequestParam String inviterName,
                                                      @RequestParam Integer listId) {
        emailService.sendContributorConfirmationEmail(inviterName,listId);
        return ResponseEntity.noContent().build();
    }
}
