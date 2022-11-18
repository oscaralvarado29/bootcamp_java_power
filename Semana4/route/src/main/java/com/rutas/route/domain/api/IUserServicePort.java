package com.rutas.route.domain.api;

import com.rutas.route.domain.model.User;

public interface IUserServicePort {
    User findUserByEmail(String userEmail);
}
