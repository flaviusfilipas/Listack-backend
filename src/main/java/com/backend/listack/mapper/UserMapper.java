package com.backend.listack.mapper;

import com.backend.listack.dto.UserDTO;
import com.backend.listack.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);
    User toEntity(UserDTO userDTO);
}
