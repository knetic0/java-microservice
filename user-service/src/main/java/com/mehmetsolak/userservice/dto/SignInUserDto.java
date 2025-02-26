package com.mehmetsolak.userservice.dto;

import lombok.Data;

@Data
public class SignInUserDto {
    private String email;
    private String password;
}
