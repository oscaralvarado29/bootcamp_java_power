package com.rutas.login.infraestructure.output.client;

import com.rutas.login.infraestructure.dto.Cognito;
import com.rutas.login.infraestructure.output.feigns.entity.LoginEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "cognitoClient", url = "https://k6gwndgg8j.execute-api.us-east-1.amazonaws.com/pdn/bootcamppowerup/Login")
        public interface CognitoClient {
    @PostMapping
    public ResponseEntity<Cognito> Login(LoginEntity loginEntity);
}
