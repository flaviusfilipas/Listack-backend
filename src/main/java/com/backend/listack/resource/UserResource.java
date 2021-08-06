package com.backend.listack.resource;

import com.backend.listack.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserResource {
    private final UserService userService;
}
