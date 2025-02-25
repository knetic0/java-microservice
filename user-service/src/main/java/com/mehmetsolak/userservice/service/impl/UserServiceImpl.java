package com.mehmetsolak.userservice.service.impl;

import com.mehmetsolak.userservice.dto.CreateUserDto;
import com.mehmetsolak.userservice.entity.User;
import com.mehmetsolak.userservice.repository.UserRepository;
import com.mehmetsolak.userservice.service.PasswordService;
import com.mehmetsolak.userservice.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public final class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordService passwordService;

    public UserServiceImpl(UserRepository userRepository, PasswordService passwordService) {
        this.userRepository = userRepository;
        this.passwordService = passwordService;
    }

    @Override
    public void save(CreateUserDto dto) {
        final String hashedPassword = passwordService.encryptPassword(dto.getPassword());
        final User user = dto.toEntity(hashedPassword);
        userRepository.save(user);
    }
}
