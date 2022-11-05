package com.rutas.signup.infraestructure.output.jpa.mapper;

import com.rutas.signup.domain.model.User;
import com.rutas.signup.infraestructure.output.jpa.entity.UserEntity;

public interface IUserEntityMapper {

    UserEntity toUserEntity(User user);
    User toUser(UserEntity userEntity);
}
