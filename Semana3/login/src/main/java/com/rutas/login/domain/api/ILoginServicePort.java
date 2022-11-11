package com.rutas.login.domain.api;

import com.rutas.login.domain.model.Login;

public interface ILoginServicePort {
    String generateToken(Login login);
}
