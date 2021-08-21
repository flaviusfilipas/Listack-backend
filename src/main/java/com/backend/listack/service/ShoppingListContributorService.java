package com.backend.listack.service;

import com.backend.listack.dto.ShoppingListContributorDTO;
import com.backend.listack.entity.ShoppingListContributor;
import com.backend.listack.mapper.ShoppingListContributorMapper;
import com.backend.listack.repository.ShoppingListContributorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class ShoppingListContributorService {
    private final ShoppingListContributorRepository shoppingListContributorRepository;
    private final ShoppingListContributorMapper shoppingListContributorMapper;

    public void save(ShoppingListContributorDTO shoppingListContributorDTO){
        ShoppingListContributor entity = shoppingListContributorMapper.toEntity(shoppingListContributorDTO);
        shoppingListContributorRepository.save(entity);
    }

    public void save(String userId, Integer listId) {
        ShoppingListContributorDTO shoppingListContributorDTO = createShoppingListContributorDTO(userId, listId);
        ShoppingListContributor entity = shoppingListContributorMapper.toEntity(shoppingListContributorDTO);
        shoppingListContributorRepository.save(entity);
    }

    private ShoppingListContributorDTO createShoppingListContributorDTO(String userId, Integer listId) {
        ShoppingListContributorDTO shoppingListContributorDTO = new ShoppingListContributorDTO();
        shoppingListContributorDTO.setShoppingListId(listId);
        shoppingListContributorDTO.setUserId(userId);
        return shoppingListContributorDTO;
    }

    public List<ShoppingListContributorDTO> findAllByListId(Integer id) {
       return shoppingListContributorRepository.findAllByShoppingListId(id)
                .stream()
                .map(shoppingListContributorMapper::toDto)
                .collect(toList());
    }
}
