package com.backend.listack.dto;

import lombok.Data;

@Data
public class ContributorInvitationDTO {
    private Integer id;
    private String email;
    private String status;
    private Boolean sentEmail;
    private Integer shoppingListId;
}
