package com.rutas.login.application.mapper;

import com.rutas.login.application.dto.LoginRequest;
import com.rutas.login.domain.model.Login;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface LoginRequestMapper {
    Login toLogin(LoginRequest loginRequest);

}
