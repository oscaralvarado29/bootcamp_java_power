package com.rutas.conductor.creacion_de_rutas.applicaton.handler;

import com.rutas.conductor.creacion_de_rutas.applicaton.dto.UserRequest;
import com.rutas.conductor.creacion_de_rutas.applicaton.dto.UserResponse;

import java.util.List;

public interface IUserHandler {
    void saveUserInDB(UserRequest userRequest);
    List<UserResponse> getAllUsersFromDB();
    UserResponse getUserFromDB(Long id);
    UserResponse getUserFromDBByEmail(String email);
    void deleteUserInDB(String email);
    void updateUserInDB(UserRequest userRequest);
}
