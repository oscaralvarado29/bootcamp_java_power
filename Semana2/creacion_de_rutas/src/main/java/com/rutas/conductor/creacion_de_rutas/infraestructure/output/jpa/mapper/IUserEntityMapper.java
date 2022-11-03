package com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.mapper;

import com.rutas.conductor.creacion_de_rutas.domain.model.User;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserEntityMapper {

    UserEntity toUserEntity(User user);
    User toUser(UserEntity userEntity);
    List<User> toUserList(List<UserEntity> userEntityList);
    List<UserEntity> toUserEntityList(List<User> userList);
}
