package com.backend.listack.dto;

import lombok.Getter;
import lombok.Setter;

public class UserDTO {
    @Getter
    private String id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String email;
}
