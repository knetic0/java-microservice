package com.mehmetsolak.userservice.service;

import com.mehmetsolak.userservice.core.result.Result;
import com.mehmetsolak.userservice.dto.CreateUserDto;
import com.mehmetsolak.userservice.dto.SignInUserResponseDto;
import com.mehmetsolak.userservice.dto.SignInUserDto;

public interface UserService {
    void save(CreateUserDto dto);
    Result<SignInUserResponseDto> login(SignInUserDto dto);
}
