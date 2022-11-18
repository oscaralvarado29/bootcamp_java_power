package com.rutas.login.domain.spi;

import com.rutas.login.domain.model.Login;

public interface ILoginPersistancePort {
    String generateToken(Login login);
}
