package com.rutas.login.application.handler;

import com.rutas.login.application.dto.LoginRequest;
import com.rutas.login.domain.model.Login;

public interface ILoginHandler {
    String generateToken(LoginRequest loginRequest);
}
