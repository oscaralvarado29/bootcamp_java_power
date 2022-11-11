package com.rutas.login.infraestructure.configuration;

import com.rutas.login.domain.api.ILoginServicePort;
import com.rutas.login.domain.spi.ILoginPersistancePort;
import com.rutas.login.domain.usecase.LoginUseCase;
import com.rutas.login.infraestructure.output.client.CognitoLoginClient;
import com.rutas.login.infraestructure.output.client.SignupClient;
import com.rutas.login.infraestructure.output.feigns.adapter.LoginFeignsAdapter;
import com.rutas.login.infraestructure.output.feigns.mapper.LoginEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final CognitoLoginClient cognitoLoginClient;
    private final SignupClient signupClient;
    private final LoginEntityMapper loginEntityMapper;

    @Bean
    public ILoginPersistancePort loginPersistancePort() {
        return new LoginFeignsAdapter(cognitoLoginClient, signupClient, loginEntityMapper);
    }

    @Bean
    public ILoginServicePort loginServicePort() {
        return new LoginUseCase(loginPersistancePort());
    }
}
