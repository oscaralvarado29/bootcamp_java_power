package com.rutas.signup.application.handler;

import com.rutas.signup.application.dto.UserRequest;
import com.rutas.signup.application.dto.UserResponse;

import java.util.List;

public interface IUserHandler {
    void saveUserInDB(UserRequest userRequest);
    UserResponse getUserFromDBByEmail(String email);

}
