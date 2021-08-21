package com.backend.listack.mapper;

import com.backend.listack.dto.ContributorInvitationDTO;
import com.backend.listack.entity.ContributorInvitation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContributorInvitationMapper {
    @Mapping(source = "shoppingList.id", target = "shoppingListId")
    ContributorInvitationDTO toDto(ContributorInvitation contributorInvitation);
    @Mapping(source = "shoppingListId", target = "shoppingList.id")
    ContributorInvitation toEntity(ContributorInvitationDTO contributorInvitationDTO);
}
