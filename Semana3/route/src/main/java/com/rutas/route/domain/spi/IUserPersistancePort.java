package com.rutas.route.domain.spi;

import com.rutas.route.domain.model.User;

public interface IUserPersistancePort {
    User findUserByEmail(String userEmail);
}
