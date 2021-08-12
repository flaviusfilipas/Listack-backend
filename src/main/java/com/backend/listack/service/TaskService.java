package com.backend.listack.service;

import com.backend.listack.dto.TaskDTO;
import com.backend.listack.entity.Task;
import com.backend.listack.mapper.TaskMapper;
import com.backend.listack.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskDTO save(TaskDTO taskDTO) {
        Task task = taskMapper.toEntity(taskDTO);
        Task savedEntity = taskRepository.save(task);
        return taskMapper.toDTO(savedEntity);
    }

    public void delete(Integer id) {
        taskRepository.deleteById(id);
    }

    @Transactional
    public void deleteCompletedTasks(Integer listId) {
        taskRepository.deleteCompletedTasks(listId);
    }

    public List<TaskDTO> findAllByListId(Integer id) {
        return taskRepository.findByListId(id)
                .stream()
                .map(taskMapper::toDTO)
                .collect(Collectors.toList());
    }
}
