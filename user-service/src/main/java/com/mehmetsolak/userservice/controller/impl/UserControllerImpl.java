package com.mehmetsolak.userservice.controller.impl;

import com.mehmetsolak.userservice.constant.RequestMappingName;
import com.mehmetsolak.userservice.controller.UserController;
import com.mehmetsolak.userservice.dto.CreateUserDto;
import com.mehmetsolak.userservice.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RequestMappingName.USER)
public class UserControllerImpl implements UserController {
    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void create(@RequestBody CreateUserDto dto) {
        userService.save(dto);
    }
}
