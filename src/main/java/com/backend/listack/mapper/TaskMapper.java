package com.backend.listack.mapper;

import com.backend.listack.dto.TaskDTO;
import com.backend.listack.entity.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDTO toDTO(Task task);
    Task toEntity(TaskDTO taskDTO);
}
