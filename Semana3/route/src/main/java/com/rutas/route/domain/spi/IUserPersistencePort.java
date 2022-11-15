package com.rutas.route.domain.spi;

import com.rutas.route.domain.model.User;

public interface IUserPersistencePort {
    User findUserByEmail(String userEmail);
}
