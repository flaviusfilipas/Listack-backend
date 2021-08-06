package com.backend.listack.service;

import com.backend.listack.mapper.TaskMapper;
import com.backend.listack.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
}
