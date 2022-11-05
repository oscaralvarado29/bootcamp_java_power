package com.rutas.signup.infraestructure.configuration;

import com.rutas.signup.domain.api.IUserServicePort;
import com.rutas.signup.domain.spi.IUserPersistencePort;
import com.rutas.signup.domain.usecase.UserUseCase;
import com.rutas.signup.infraestructure.output.client.ICognitoClient;
import com.rutas.signup.infraestructure.output.jpa.adapter.UserJpaAdapter;
import com.rutas.signup.infraestructure.output.jpa.mapper.IUserEntityMapper;
import com.rutas.signup.infraestructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
public class BeanConfiguration {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;
    private final ICognitoClient cognitoClient;
    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserJpaAdapter(userRepository, cognitoClient, userEntityMapper);
    }

    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort());
    }
}
