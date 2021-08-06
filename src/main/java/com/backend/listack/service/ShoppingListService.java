package com.backend.listack.service;

import com.backend.listack.mapper.ShoppingListContributorMapper;
import com.backend.listack.repository.ShoppingListContributorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShoppingListService {
    private final ShoppingListContributorRepository shoppingListContributorRepository;
    private final ShoppingListContributorMapper shoppingListContributorMapper;
}
