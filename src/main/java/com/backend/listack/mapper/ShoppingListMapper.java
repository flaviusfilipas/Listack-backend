package com.backend.listack.mapper;

import com.backend.listack.dto.ShoppingListDTO;
import com.backend.listack.entity.ShoppingList;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShoppingListMapper {
    ShoppingListDTO toDTO(ShoppingList shoppingList);
    ShoppingList toEntity(ShoppingListDTO shoppingListDTO);
}
