package com.backend.listack.resource;

import com.backend.listack.dto.ShoppingListDTO;
import com.backend.listack.dto.custom.UserShoppingListDTO;
import com.backend.listack.entity.ShoppingList;
import com.backend.listack.service.ShoppingListContributorService;
import com.backend.listack.service.ShoppingListService;
import com.backend.listack.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/shopping-lists")
@CrossOrigin("*")
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
    @PutMapping
    public ResponseEntity<ShoppingListDTO> update(@RequestBody ShoppingListDTO shoppingListDTO){
        if(shoppingListDTO.getId() == null){
            log.error("Could not update a list without an id");
            return ResponseEntity.badRequest().build();
        }
        ShoppingListDTO updatedList = shoppingListService.save(shoppingListDTO);
        return ResponseEntity.ok(updatedList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        shoppingListService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<List<ShoppingListDTO>> getShoppingListByUserId(@PathVariable String id){
        List<ShoppingListDTO> shoppingListByUserId = shoppingListService.findShoppingListByUserId(id);
        return ResponseEntity.ok(shoppingListByUserId);
    }
}
