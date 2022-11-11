package com.rutas.login.infraestructure.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private String username;
    private String email;
    private String password;
}
