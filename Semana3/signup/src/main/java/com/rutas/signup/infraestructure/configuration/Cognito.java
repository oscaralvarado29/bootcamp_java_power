package com.rutas.signup.infraestructure.configuration;

import com.ctc.wstx.shaded.msv_core.verifier.regexp.StringToken;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtParserBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.apache.commons.codec.binary.Base64;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cognito {
    private int statusCode;
    private String[] body;
    private boolean isBase64Encoded;

    public Cognito(int statusCode, String body, boolean isBase64Encoded) {
        this.statusCode = statusCode;
        this.body = body.split(",");
        this.isBase64Encoded = isBase64Encoded;
    }
}

