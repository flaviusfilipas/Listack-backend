package com.backend.listack.dto;

import lombok.Getter;
import lombok.Setter;

public class ShoppingListContributorDTO {
    @Getter
    private Integer id;
    @Getter
    @Setter
    private Integer shoppingListId;
    @Getter
    @Setter
    private String userId;
    @Getter
    @Setter
    private String email;
}
