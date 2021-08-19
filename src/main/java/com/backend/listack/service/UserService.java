package com.backend.listack.service;

import com.backend.listack.dto.UserDTO;
import com.backend.listack.entity.User;
import com.backend.listack.mapper.UserMapper;
import com.backend.listack.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDTO save(UserDTO userDTO){
        User entity = userMapper.toEntity(userDTO);
        User savedUser = userRepository.save(entity);
        return userMapper.toDTO(savedUser);
    }
    public UserDTO findById(String id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not find user with id " + id));
        return userMapper.toDTO(user);
    }

    public UserDTO getById(String id) {

        User userById = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not found user with id" + id));
        return userMapper.toDTO(userById);
    }
}
