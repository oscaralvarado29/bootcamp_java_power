package com.rutas.login.domain.usecase;

import com.rutas.login.domain.api.ILoginServicePort;
import com.rutas.login.domain.model.Login;
import com.rutas.login.domain.spi.ILoginPersistancePort;

public class LoginUseCase implements ILoginServicePort {

    private final ILoginPersistancePort loginPersistancePort;

    public LoginUseCase(ILoginPersistancePort loginPersistancePort) {
        this.loginPersistancePort = loginPersistancePort;
    }

    /**
     * @param login
     * @return
     */
    @Override
    public String generateToken(Login login) {
        return loginPersistancePort.generateToken(login);
    }
}
