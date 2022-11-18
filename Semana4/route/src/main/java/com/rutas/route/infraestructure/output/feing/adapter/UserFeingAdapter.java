package com.rutas.route.infraestructure.output.feing.adapter;

import com.rutas.route.domain.model.User;
import com.rutas.route.domain.spi.IUserPersistencePort;
import com.rutas.route.infraestructure.output.client.UserClient;
import com.rutas.route.infraestructure.output.feing.mapper.UserRequestMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserFeingAdapter implements IUserPersistencePort {

    private final UserClient userClient;
    private final UserRequestMapper userRequestMapper;

    @Override
    public User findUserByEmail(String userEmail) {
        return userRequestMapper.toUser(userClient.getUserFromDBByEmail(userEmail).getBody());
    }
}
