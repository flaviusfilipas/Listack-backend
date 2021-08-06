package com.backend.listack.dto;

import lombok.Data;

@Data
public class ShoppingListDTO {
    private Integer id;
    private String title;
    private LocationDTO location;
}
