package com.rutas.route.infraestructure.output.feing.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private Long userId;
    private String username;
    private String email;
    private String password;
}
