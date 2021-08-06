package com.backend.listack.resource;

import com.backend.listack.service.ShoppingListContributorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ShoppingListResource {
    private final ShoppingListContributorService shoppingListContributorService;
}
