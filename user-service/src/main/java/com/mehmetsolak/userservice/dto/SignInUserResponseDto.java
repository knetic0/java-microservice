package com.mehmetsolak.userservice.dto;

import com.mehmetsolak.userservice.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SignInUserResponseDto extends UserDto {
    private String token;

    public SignInUserResponseDto() {}

    public SignInUserResponseDto(User user, String token) {
        super(user);
        this.token = token;
    }
}
