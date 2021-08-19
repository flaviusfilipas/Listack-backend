package com.backend.listack.resource;

import com.backend.listack.dto.UserDTO;
import com.backend.listack.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserResource {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO userDTO){
        UserDTO savedUser = userService.save(userDTO);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable String id){
        UserDTO user = userService.getById(id);
        return ResponseEntity.ok(user);
    }

}
