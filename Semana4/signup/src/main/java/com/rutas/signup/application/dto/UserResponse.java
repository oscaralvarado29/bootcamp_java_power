package com.rutas.signup.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private Long userId;
    private String username;
    private String email;
    private String password;
}
