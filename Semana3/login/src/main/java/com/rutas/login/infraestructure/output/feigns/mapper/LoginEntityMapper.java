package com.rutas.login.infraestructure.output.feigns.mapper;


import com.rutas.login.domain.model.Login;
import com.rutas.login.infraestructure.output.feigns.entity.LoginEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface LoginEntityMapper {
    default LoginEntity toLoginEntity(String name, Login login) {
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setName(name);
        loginEntity.setPassword(login.getPassword());
        return loginEntity;
    }
}
