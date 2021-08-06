package com.backend.listack.dto;

import lombok.Data;

@Data
public class ListContributorDTO {
    private Integer id;
    private Integer listId;
    private String userId;
}
