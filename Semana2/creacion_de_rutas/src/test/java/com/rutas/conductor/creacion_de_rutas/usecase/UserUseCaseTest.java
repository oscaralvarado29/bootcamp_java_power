package com.rutas.conductor.creacion_de_rutas.usecase;

import com.rutas.conductor.creacion_de_rutas.domain.exceptions.EmailInvalidFormatException;
import com.rutas.conductor.creacion_de_rutas.domain.exceptions.MissingMandatoryDataException;
import com.rutas.conductor.creacion_de_rutas.domain.exceptions.PasswordInvalidFormatException;
import com.rutas.conductor.creacion_de_rutas.domain.factory.FactoryUserDataTest;
import com.rutas.conductor.creacion_de_rutas.domain.model.User;
import com.rutas.conductor.creacion_de_rutas.domain.spi.IUserPersistencePort;
import com.rutas.conductor.creacion_de_rutas.domain.usecase.UserUseCase;
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
        user.setUserEmail("oscar.outlook.com");
        assertThrows(EmailInvalidFormatException.class, () -> userUseCase.saveUser(user));
    }

    @Test
    void trowMissingMandatoryDataExceptionWhenMissingAttribute() {
        user.setUserName(null);
        assertThrows(MissingMandatoryDataException.class, () -> userUseCase.saveUser(user));
    }

    @Test
    void trowPasswordInvalidFormatExceptionWhenPasswordIsInvalid() {
        user.setUserPassword("Contrasena123*-");
        assertThrows(PasswordInvalidFormatException.class, () -> userUseCase.saveUser(user));
    }
    @Test
    void updateUser() {
        userUseCase.updateUser(user);
        verify(userPersistencePort).updateUser(any(User.class));
    }

    @Test
    void deleteUser() {
        userUseCase.deleteUser(user.getUserEmail());
        verify(userPersistencePort).deleteUser(user.getUserEmail());
    }

    @Test
    void findUserByEmail() {
        userUseCase.findUserByEmail(user.getUserEmail());
        verify(userPersistencePort).findByUserEmail(user.getUserEmail());
    }

    @Test
    void getUser() {
        userUseCase.getUser(user.getUserId());
        verify(userPersistencePort).getUser(user.getUserId());
    }

    @Test
    void getAllUsers() {
        userUseCase.getAllUsers();
        verify(userPersistencePort).getAllUsers();
    }
}