package com.rutas.signup.domain.usecase;

import com.rutas.signup.domain.exception.EmailInvalidFormatException;
import com.rutas.signup.domain.exception.MissingMandatoryDataException;
import com.rutas.signup.domain.exception.PasswordInvalidFormatException;
import com.rutas.signup.domain.factory.FactoryUserDataTest;
import com.rutas.signup.domain.model.User;
import com.rutas.signup.domain.spi.IUserPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class UserUseCaseTest {

    @InjectMocks
    UserUseCase userUseCase;
    @Mock
    IUserPersistencePort userPersistencePort;
    private User user;

    @BeforeEach
    void setUp() {
        user = FactoryUserDataTest.getUser();
    }

    @Test
    void mustSaveUser() {
        userUseCase.saveUser(user);
        verify(userPersistencePort).saveUser(any(User.class));
    }

    @Test
    void trowEmailInvalidFormatExceptionWhenEmailIsInvalid() {
        user.setEmail("oscar.outlook.com");
        assertThrows(EmailInvalidFormatException.class, () -> userUseCase.saveUser(user));
    }

    @Test
    void trowMissingMandatoryDataExceptionWhenMissingAttribute() {
        user.setName(null);
        assertThrows(MissingMandatoryDataException.class, () -> userUseCase.saveUser(user));
    }

    @Test
    void trowPasswordInvalidFormatExceptionWhenPasswordIsInvalid() {
        user.setPassword("Contrasena12356");
        assertThrows(PasswordInvalidFormatException.class, () -> userUseCase.saveUser(user));
    }

    @Test
    void findUserByEmail() {
        userUseCase.findUserByEmail(user.getEmail());
        verify(userPersistencePort).findUserByEmail(user.getEmail());
    }
}