package com.rutas.conductor.creacion_de_rutas.applicaton.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private String userName;
    private String userSurname;
    private Long userPhone;
    private String userAddress;
    private String userEmail;
    private String userPassword;
}
