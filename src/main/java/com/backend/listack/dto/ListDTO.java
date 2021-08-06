package com.backend.listack.dto;

import lombok.Data;

@Data
public class ListDTO {
    private Integer id;
    private String name;
    private LocationDTO locationDTO;
}
