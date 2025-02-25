package com.mehmetsolak.userservice.service;

import com.mehmetsolak.userservice.dto.CreateUserDto;

public interface UserService {
    void save(CreateUserDto dto);
}
