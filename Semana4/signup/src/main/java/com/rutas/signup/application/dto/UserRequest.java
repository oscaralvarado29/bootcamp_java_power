package com.rutas.signup.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private String name;
    private String email;
    private String familyName;
    private String address;
    private String phoneNumber;
    private String password;
}
