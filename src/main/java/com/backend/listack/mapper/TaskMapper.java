package com.backend.listack.mapper;

import com.backend.listack.dto.TaskDTO;
import com.backend.listack.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    @Mapping(source = "list.id", target = "listId")
    TaskDTO toDTO(Task task);
    @Mapping(source = "listId", target = "list.id")
    Task toEntity(TaskDTO taskDTO);
}
