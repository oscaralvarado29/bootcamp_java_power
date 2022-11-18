package com.rutas.route.infraestructure.output.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserEntity {
    private Long userId;
    private String username;
    private String email;
    private String password;
}
