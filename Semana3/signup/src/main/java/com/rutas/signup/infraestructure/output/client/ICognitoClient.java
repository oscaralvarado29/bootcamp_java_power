package com.rutas.signup.infraestructure.output.client;

import com.rutas.signup.domain.model.User;
import com.rutas.signup.infraestructure.dto.Cognito;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "cognitoClient", url = "https://k6gwndgg8j.execute-api.us-east-1.amazonaws.com/pdn/bootcamppowerup/Signup")
public interface ICognitoClient {
    @PostMapping
    public ResponseEntity<Cognito> Signup(User user);
}
