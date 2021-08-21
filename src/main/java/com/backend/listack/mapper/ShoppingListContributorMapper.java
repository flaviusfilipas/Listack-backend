package com.backend.listack.mapper;

import com.backend.listack.dto.ShoppingListContributorDTO;
import com.backend.listack.entity.ShoppingListContributor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ShoppingListContributorMapper {
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.email", target = "email")
    @Mapping(source = "shoppingList.id", target = "shoppingListId")
    ShoppingListContributorDTO toDto(ShoppingListContributor shoppingListContributor);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "shoppingListId", target = "shoppingList.id")
    ShoppingListContributor toEntity(ShoppingListContributorDTO shoppingListContributorDTO);
}
