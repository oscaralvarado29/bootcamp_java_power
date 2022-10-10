package com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.adapter;

import com.rutas.conductor.creacion_de_rutas.domain.model.User;
import com.rutas.conductor.creacion_de_rutas.domain.spi.IUserPersistencePort;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.mapper.IUserEntityMapper;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(String userEmail) {

    }

    @Override
    public User findByUserEmail(String userEmail) {
        return null;
    }

    @Override
    public User getUser(Long id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
