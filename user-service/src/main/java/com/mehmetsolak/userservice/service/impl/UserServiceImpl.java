package com.mehmetsolak.userservice.service.impl;

import com.mehmetsolak.userservice.core.result.FailureSuccess;
import com.mehmetsolak.userservice.core.result.Result;
import com.mehmetsolak.userservice.core.result.SuccessResult;
import com.mehmetsolak.userservice.dto.CreateUserDto;
import com.mehmetsolak.userservice.dto.SignInUserDto;
import com.mehmetsolak.userservice.dto.SignInUserResponseDto;
import com.mehmetsolak.userservice.entity.User;
import com.mehmetsolak.userservice.repository.UserRepository;
import com.mehmetsolak.userservice.service.JwtService;
import com.mehmetsolak.userservice.service.PasswordService;
import com.mehmetsolak.userservice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public final class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordService passwordService;
    private final JwtService jwtService;

    public UserServiceImpl(
            UserRepository userRepository,
            PasswordService passwordService,
            JwtService jwtService
    ) {
        this.userRepository = userRepository;
        this.passwordService = passwordService;
        this.jwtService = jwtService;
    }

    @Override
    public void save(CreateUserDto dto) {
        final String hashedPassword = passwordService.encryptPassword(dto.getPassword());
        final User user = dto.toEntity(hashedPassword);
        userRepository.save(user);
    }

    @Override
    public Result<SignInUserResponseDto> login(SignInUserDto dto) {
        Optional<User> user = userRepository.findByEmail(dto.getEmail());
        if (user.isEmpty()) {
            return new FailureSuccess<>("");
        }
        final User _user = user.get();
        final String token = jwtService.generateToken(_user);
        return new SuccessResult<>(new SignInUserResponseDto(_user, token));
    }
}
