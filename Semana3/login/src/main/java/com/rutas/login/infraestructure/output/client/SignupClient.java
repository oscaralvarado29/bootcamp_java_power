package com.rutas.login.infraestructure.output.client;

import com.rutas.login.infraestructure.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "SignupClient", url = "http://localhost:8090/user")
public interface SignupClient {

    @GetMapping("/{email}")
    public ResponseEntity<UserResponse> getUserFromDBByEmail(@PathVariable(name = "email") String userEmail);
}
