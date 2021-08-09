package com.backend.listack.service;

import com.backend.listack.dto.ShoppingListDTO;
import com.backend.listack.entity.ShoppingList;
import com.backend.listack.mapper.ShoppingListMapper;
import com.backend.listack.repository.ShoppingListRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShoppingListService {
    private final ShoppingListRepository shoppingListRepository;
    private final ShoppingListMapper shoppingListMapper;

    public ShoppingListDTO save(ShoppingListDTO shoppingListDTO){
        ShoppingList entity = shoppingListMapper.toEntity(shoppingListDTO);
        ShoppingList savedEntity = shoppingListRepository.save(entity);
        return shoppingListMapper.toDTO(savedEntity);
    }

    public void delete(Integer id){
        shoppingListRepository.deleteById(id);
    }

    public List<ShoppingListDTO> findShoppingListByUserId(String id) {
        return shoppingListRepository.findShoppingListByUserId(id)
                .stream()
                .map(shoppingListMapper::toDTO)
                .collect(Collectors.toList());
    }
}
