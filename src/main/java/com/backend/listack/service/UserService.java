package com.backend.listack.service;

import com.backend.listack.mapper.UserMapper;
import com.backend.listack.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
}
