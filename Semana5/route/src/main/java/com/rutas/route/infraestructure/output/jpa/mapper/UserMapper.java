package com.rutas.route.infraestructure.output.jpa.mapper;

import com.rutas.route.domain.model.User;
import com.rutas.route.infraestructure.output.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserEntity toUserEntity(User user);
    User toUser(UserEntity userEntity);
}
