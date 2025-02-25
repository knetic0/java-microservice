package com.mehmetsolak.userservice.dto;

import com.mehmetsolak.userservice.entity.User;
import lombok.Data;

import java.util.Date;

@Data
public class CreateUserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date birthDate;

    public User toEntity(String hashedPassword) {
        return new User(firstName, lastName, email, hashedPassword, birthDate);
    }
}