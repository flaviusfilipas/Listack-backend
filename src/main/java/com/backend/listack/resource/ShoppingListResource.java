package com.backend.listack.resource;

import com.backend.listack.dto.ShoppingListDTO;
import com.backend.listack.dto.custom.UserShoppingListDTO;
import com.backend.listack.entity.ShoppingList;
import com.backend.listack.service.ShoppingListContributorService;
import com.backend.listack.service.ShoppingListService;
import com.backend.listack.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/shopping-lists")
public class ShoppingListResource {
    private final ShoppingListContributorService shoppingListContributorService;
    private final ShoppingListService shoppingListService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<ShoppingListDTO> save(@RequestBody UserShoppingListDTO userShoppingListDTO) {
        ShoppingListDTO savedList = null;
        if(userService.findById(userShoppingListDTO.getUserId()) != null){
            savedList = shoppingListService.save(userShoppingListDTO.getShoppingListDTO());
            shoppingListContributorService.save(userShoppingListDTO.getUserId(), savedList.getId());
        }
        return ResponseEntity.ok(savedList);
    }
}
