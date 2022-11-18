package com.rutas.route.infraestructure.output.jpa.adapter;


import com.rutas.route.domain.model.User;
import com.rutas.route.domain.spi.IUserPersistencePort;
import com.rutas.route.infraestructure.output.jpa.entity.UserEntity;
import com.rutas.route.infraestructure.output.jpa.mapper.UserMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {
    private final UserMapper userMapper;
    @Override
    public User findUserByEmail(String userEmail) {
        return userMapper.toUser(new UserEntity(1L,"Cristian_0bd32268-4f6e-4117-85b4-b01bae855d7b","cristian.alvares@gmail.com","HolaMundo1234*"));
    }
}
