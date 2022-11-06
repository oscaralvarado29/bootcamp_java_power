package com.rutas.signup.infraestructure.output.jpa.mapper;

import com.rutas.signup.domain.model.User;
import com.rutas.signup.infraestructure.output.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserEntityMapper {

    UserEntity toUserEntity(User user);
    User toUser(UserEntity userEntity);
}
