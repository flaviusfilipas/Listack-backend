package com.backend.listack.resource;

import com.backend.listack.dto.TaskDTO;
import com.backend.listack.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/tasks")
public class TaskResource {
    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDTO> save(@RequestBody TaskDTO taskDTO){
        TaskDTO save = taskService.save(taskDTO);
        return ResponseEntity.ok(save);
    }
    @PutMapping
    public ResponseEntity<TaskDTO> update(@RequestBody TaskDTO taskDTO){
        if(taskDTO.getId() == null){
            log.error("Could not updated a task without an id");
            return ResponseEntity.badRequest().build();
        }
        TaskDTO save = taskService.save(taskDTO);
        return ResponseEntity.ok(save);
    }
}
