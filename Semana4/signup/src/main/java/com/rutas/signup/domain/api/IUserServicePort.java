package com.rutas.signup.domain.api;

import com.rutas.signup.domain.model.User;

import java.util.List;

public interface IUserServicePort {
    void saveUser(User user);;
    User findUserByEmail(String userEmail);
}
