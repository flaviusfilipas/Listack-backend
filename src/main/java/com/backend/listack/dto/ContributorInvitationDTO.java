package com.backend.listack.dto;

import lombok.Getter;
import lombok.Setter;

public class ContributorInvitationDTO {
    @Getter
    private Integer id;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String status;
    @Getter
    @Setter
    private Boolean sentEmail;
    @Getter
    @Setter
    private Integer shoppingListId;
}
