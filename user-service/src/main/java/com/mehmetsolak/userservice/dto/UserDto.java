package com.mehmetsolak.userservice.dto;

import com.mehmetsolak.userservice.entity.User;
import lombok.Data;

import java.util.Date;

@Data
public class UserDto {
    private String firstName;
    private String lastName;
    private String email;
    private Date birthDate;
    private Date createdAt;
    private Date updatedAt;

    public UserDto() {}

    public UserDto(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.birthDate = user.getBirthDate();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
    }
}
