package com.rutas.signup.application.mapper;

import com.rutas.signup.application.dto.UserResponse;
import com.rutas.signup.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserResponseMapper {
    UserResponse toUserResponse(User user);
}
