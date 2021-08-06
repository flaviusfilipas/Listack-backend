package com.backend.listack.resource;

import com.backend.listack.dto.TaskDTO;
import com.backend.listack.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/tasks")
public class TaskResource {
    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDTO> save(@RequestBody TaskDTO taskDTO){
        TaskDTO save = taskService.save(taskDTO);
        return ResponseEntity.ok(save);
    }
}
