package com.rutas.route.domain.usecase;

import com.rutas.route.domain.api.IUserServicePort;
import com.rutas.route.domain.model.User;
import com.rutas.route.domain.spi.IUserPersistencePort;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistancePort;

    public UserUseCase(IUserPersistencePort userPersistancePort) {
        this.userPersistancePort = userPersistancePort;
    }

    @Override
    public User findUserByEmail(String userEmail) {
        return userPersistancePort.findUserByEmail(userEmail);
    }
}
