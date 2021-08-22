package com.backend.listack.resource;

import com.backend.listack.dto.ContributorInvitationDTO;
import com.backend.listack.service.ContributorInvitationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
@RequestMapping("/api/contributor-invitations")
public class ContributorInvitationResource {
    private final ContributorInvitationService contributorInvitationService;

    @PostMapping
    public ResponseEntity<ContributorInvitationDTO> save(@RequestBody ContributorInvitationDTO contributorInvitationDTO) {
        ContributorInvitationDTO savedInvitation = contributorInvitationService.save(contributorInvitationDTO);
        return ResponseEntity.ok(savedInvitation);
    }

    @PutMapping("/approve")
    public ResponseEntity<ContributorInvitationDTO> approveContributorInvitation(@RequestParam String userId,
                                                                                 @RequestParam Integer listId) {
        ContributorInvitationDTO updatedInvitation = contributorInvitationService.approveInvitation(userId, listId);
        return ResponseEntity.ok(updatedInvitation);

    }

    @PutMapping
    public ResponseEntity<ContributorInvitationDTO> update(@RequestBody ContributorInvitationDTO contributorInvitationDTO) {
        if (contributorInvitationDTO.getId() == null) {
            throw new IllegalArgumentException("Could not update an entity without an id");
        }
        ContributorInvitationDTO savedInvitation = contributorInvitationService.save(contributorInvitationDTO);
        return ResponseEntity.ok(savedInvitation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        contributorInvitationService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContributorInvitationDTO> findById(@PathVariable Integer id) {
        ContributorInvitationDTO contributorInvitation = contributorInvitationService.findById(id);
        return ResponseEntity.ok(contributorInvitation);
    }

    @GetMapping("/pending/list/{id}")
    public ResponseEntity<List<ContributorInvitationDTO>> findAllPendingInvitationsByListId(@PathVariable Integer id) {
        List<ContributorInvitationDTO> allByListId = contributorInvitationService.findAllPendingInvitationsByListId(id);
        return ResponseEntity.ok(allByListId);
    }
}
