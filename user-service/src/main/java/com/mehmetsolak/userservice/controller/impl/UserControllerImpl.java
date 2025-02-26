package com.mehmetsolak.userservice.controller.impl;

import com.mehmetsolak.userservice.constant.RequestMappingName;
import com.mehmetsolak.userservice.controller.UserController;
import com.mehmetsolak.userservice.core.result.Result;
import com.mehmetsolak.userservice.dto.CreateUserDto;
import com.mehmetsolak.userservice.dto.SignInUserDto;
import com.mehmetsolak.userservice.dto.SignInUserResponseDto;
import com.mehmetsolak.userservice.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RequestMappingName.USER)
public class UserControllerImpl implements UserController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    public UserControllerImpl(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void create(@RequestBody CreateUserDto dto) {
        userService.save(dto);
    }

    @Override
    public Result<SignInUserResponseDto> login(@RequestBody SignInUserDto dto) {
        authenticate(dto.getEmail(), dto.getPassword());

        return null;
    }

    private void authenticate(String email, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
    }
}
