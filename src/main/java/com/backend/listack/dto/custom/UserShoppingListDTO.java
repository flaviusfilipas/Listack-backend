package com.backend.listack.dto.custom;

import com.backend.listack.dto.ShoppingListDTO;
import lombok.Data;

@Data
public class UserShoppingListDTO {
    private String userId;
    private ShoppingListDTO shoppingListDTO;
}
