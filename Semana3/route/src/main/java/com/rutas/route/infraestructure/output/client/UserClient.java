package com.rutas.route.infraestructure.output.client;

import com.rutas.route.infraestructure.output.feing.entity.UserRequest;
import com.rutas.route.infraestructure.output.client.configuration.UserClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "userClient",configuration = UserClientConfiguration.class, url = "http://localhost:8090/user")
public interface UserClient {
    @GetMapping("/{email}")
    public ResponseEntity<UserRequest> getUserFromDBByEmail(@PathVariable(name = "email") String userEmail);
}
