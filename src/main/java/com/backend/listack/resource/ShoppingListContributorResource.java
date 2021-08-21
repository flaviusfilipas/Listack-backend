package com.backend.listack.resource;

import com.backend.listack.dto.ShoppingListContributorDTO;
import com.backend.listack.service.ShoppingListContributorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/api/shopping-list-contributors")
public class ShoppingListContributorResource {
    private final ShoppingListContributorService shoppingListContributorService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ShoppingListContributorDTO shoppingListContributorDTO) {
        shoppingListContributorService.save(shoppingListContributorDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<List<ShoppingListContributorDTO>> getAllByListId(@PathVariable Integer id) {
        List<ShoppingListContributorDTO> allByListId = shoppingListContributorService.findAllByListId(id);
        return ResponseEntity.ok(allByListId);
    }
}
