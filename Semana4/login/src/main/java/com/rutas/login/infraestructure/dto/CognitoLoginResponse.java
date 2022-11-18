package com.rutas.login.infraestructure.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CognitoLoginResponse {
    private int statusCode;
    private String[] body;
    private boolean isBase64Encoded;

    public CognitoLoginResponse(int statusCode, String body, boolean isBase64Encoded) {
        this.statusCode = statusCode;
        this.body = body.split(",");
        this.isBase64Encoded = isBase64Encoded;
    }
}
