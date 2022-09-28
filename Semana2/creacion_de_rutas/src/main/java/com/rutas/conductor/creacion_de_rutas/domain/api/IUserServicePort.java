package com.rutas.conductor.creacion_de_rutas.domain.api;

import com.rutas.conductor.creacion_de_rutas.domain.model.User;

import java.util.List;

public interface IUserServicePort {
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(String userEmail);
    User getUser(String userEmail);
    List<User> getAllUsers();
}
