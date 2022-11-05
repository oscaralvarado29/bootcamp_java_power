package com.rutas.signup.infraestructure.configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cognito {
    private String statusCode;
    private String body;
    private boolean isBase64Encoded;
}
