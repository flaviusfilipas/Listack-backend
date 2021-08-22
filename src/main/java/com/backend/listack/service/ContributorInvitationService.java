package com.backend.listack.service;

import com.backend.listack.dto.ContributorInvitationDTO;
import com.backend.listack.dto.UserDTO;
import com.backend.listack.entity.ContributorInvitation;
import com.backend.listack.enums.InvitationStatus;
import com.backend.listack.mapper.ContributorInvitationMapper;
import com.backend.listack.repository.ContributorInvitationRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Data
@Service
@AllArgsConstructor
public class ContributorInvitationService {
    private final ContributorInvitationRepository contributorInvitationRepository;
    private final ContributorInvitationMapper contributorInvitationMapper;
    private final UserService userService;

    public ContributorInvitationDTO save(ContributorInvitationDTO contributorInvitationDTO) {
        ContributorInvitation entity = contributorInvitationMapper.toEntity(contributorInvitationDTO);
        ContributorInvitation savedEntity = contributorInvitationRepository.save(entity);
        return contributorInvitationMapper.toDto(savedEntity);
    }

    public ContributorInvitationDTO findById(Integer id) {
        ContributorInvitation contributorInvitation = contributorInvitationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not found contributor invitation with id " + id));
        return contributorInvitationMapper.toDto(contributorInvitation);
    }

    public void delete(Integer id) {
        contributorInvitationRepository.deleteById(id);
    }

    public List<ContributorInvitationDTO> findAllPendingInvitationsByListId(Integer id) {
        return contributorInvitationRepository.findAllPendingInvitationsByListId(id)
                .stream()
                .map(contributorInvitationMapper::toDto)
                .collect(toList());
    }

    public ContributorInvitationDTO approveInvitation(String userId, Integer listId) {
        UserDTO userDTO = userService.findById(userId);
        ContributorInvitation invitation = contributorInvitationRepository.findByEmailAndShoppingListId(userDTO.getEmail(), listId);
        invitation.setStatus(InvitationStatus.APPROVED);
        ContributorInvitation savedInvitation = contributorInvitationRepository.save(invitation);
        return contributorInvitationMapper.toDto(savedInvitation);
    }
}
