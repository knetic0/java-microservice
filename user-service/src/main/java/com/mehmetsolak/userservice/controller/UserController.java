package com.mehmetsolak.userservice.controller;

import com.mehmetsolak.userservice.constant.RequestMappingName;
import com.mehmetsolak.userservice.core.result.Result;
import com.mehmetsolak.userservice.dto.CreateUserDto;
import com.mehmetsolak.userservice.dto.SignInUserDto;
import com.mehmetsolak.userservice.dto.SignInUserResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface UserController {
    @PostMapping(RequestMappingName.CREATE_USER)
    @ResponseStatus(HttpStatus.CREATED)
    void create(@RequestBody CreateUserDto dto);

    @PostMapping(RequestMappingName.SIGN_IN_USER)
    @ResponseStatus(HttpStatus.OK)
    Result<SignInUserResponseDto> login(@RequestBody SignInUserDto dto);
}
