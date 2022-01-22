package com.backend.listack.dto;

import lombok.Getter;
import lombok.Setter;

public class TaskDTO {

    @Getter
    private Integer id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private Boolean completed;
    @Getter
    @Setter
    private Integer listId;
}
