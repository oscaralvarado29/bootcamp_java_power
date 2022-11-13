package com.rutas.login.domain.usecase;

import com.rutas.login.domain.model.Login;
import com.rutas.login.domain.spi.ILoginPersistancePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class LoginUseCaseTest {

    @InjectMocks
    LoginUseCase loginUseCase;
    @Mock
    ILoginPersistancePort loginPersistancePort;

    @Test
    void mustGenerateIdToken() {
        Login login = new Login("cristian.alvares@gmail.com", "HolaMundo1234*");
        loginUseCase.generateToken(login);
        verify(loginPersistancePort).generateToken(any(Login.class));
    }
}