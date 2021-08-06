package com.backend.listack.dto;

import lombok.Data;

@Data
public class TaskDTO {
    private Integer id;
    private String name;
    private Boolean canceled;
    private Integer listId;
}
