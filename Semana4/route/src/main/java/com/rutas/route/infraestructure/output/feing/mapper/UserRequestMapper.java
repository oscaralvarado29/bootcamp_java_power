package com.rutas.route.infraestructure.output.feing.mapper;

import com.rutas.route.infraestructure.output.feing.entity.UserRequest;
import com.rutas.route.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserRequestMapper {
    User toUser(UserRequest userRequest);
}
