package com.backend.listack.dto;

import lombok.Getter;
import lombok.Setter;

public class ShoppingListDTO {
    @Getter
    private Integer id;
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private LocationDTO location;
}
