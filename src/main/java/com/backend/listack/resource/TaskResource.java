package com.backend.listack.resource;

import com.backend.listack.dto.TaskDTO;
import com.backend.listack.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/tasks")
@CrossOrigin("*")
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
            log.error("Could not update a task without an id");
            return ResponseEntity.badRequest().build();
        }
        TaskDTO save = taskService.save(taskDTO);
        return ResponseEntity.ok(save);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/completed/{listId}")
    public ResponseEntity<Void> deleteCompletedTasks(@PathVariable Integer listId){
        taskService.deleteCompletedTasks(listId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/list/{id}")
    public ResponseEntity<List<TaskDTO>> getTasksByListId(@PathVariable Integer id){
        List<TaskDTO> allByListId = taskService.findAllByListId(id);
        return ResponseEntity.ok(allByListId);
    }
}
