package com.backend.listack.dto;

import lombok.Data;

@Data
public class ShoppingListContributorDTO {
    private Integer id;
    private Integer listId;
    private String userId;
}