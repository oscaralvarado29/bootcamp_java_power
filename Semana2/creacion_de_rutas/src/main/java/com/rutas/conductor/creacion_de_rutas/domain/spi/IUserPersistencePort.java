package com.rutas.conductor.creacion_de_rutas.domain.spi;

import com.rutas.conductor.creacion_de_rutas.domain.model.User;

import java.util.List;

public interface IUserPersistencePort {
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(String userEmail);
    User findByUserEmail(String userEmail);
    List<User> getAllUsers();

}
