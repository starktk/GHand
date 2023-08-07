package com.example.GHand.dto.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserCreateDto {

    private String name;
    private String email;
    private String password;
}
