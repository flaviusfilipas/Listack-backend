package com.backend.listack.resource;

import com.backend.listack.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TaskResource {
    private final TaskService taskService;
}
