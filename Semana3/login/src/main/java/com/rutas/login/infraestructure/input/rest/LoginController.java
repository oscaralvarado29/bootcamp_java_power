package com.rutas.login.infraestructure.input.rest;

import com.rutas.login.application.dto.LoginRequest;
import com.rutas.login.application.handler.ILoginHandler;
import com.rutas.login.infraestructure.dto.LoginResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RequiredArgsConstructor
@RestController
@RequestMapping("/login")
public class LoginController {

    private final ILoginHandler loginHandler;

    @Operation(summary = "Login process")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Login accepted", content = @Content),
            @ApiResponse(responseCode = "409", description = "Login not allowed", content = @Content)
    })
    @PostMapping("/save")
    public ResponseEntity<String> saveUserInDB(@RequestBody LoginRequest loginRequest){
        return  ResponseEntity.accepted().body(loginHandler.generateToken(loginRequest));
    }
}
