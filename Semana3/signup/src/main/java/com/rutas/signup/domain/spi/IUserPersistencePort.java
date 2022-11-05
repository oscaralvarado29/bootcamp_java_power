package com.rutas.signup.domain.spi;

import com.rutas.signup.domain.model.User;

public interface IUserPersistencePort {
    void saveUser(User user);
    User findUserByEmail(String userEmail);
}
