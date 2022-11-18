package com.rutas.route.domain.usecase;

import com.rutas.route.domain.model.User;
import com.rutas.route.domain.spi.IUserPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class UserUseCaseTest {

    @InjectMocks
    UserUseCase userUseCase;
    @Mock
    IUserPersistencePort userPersistencePort;
    private final User user = new User();

    @BeforeEach
    void setUp() {
        user.setUserId(1L);
        user.setEmail("cristian.alvares@gmail.com");
    }

    @Test
    void mustRequestSignupClientFindUserByEmailInDB() {
        userUseCase.findUserByEmail(user.getEmail());
        verify(userPersistencePort).findUserByEmail(user.getEmail());
    }
}