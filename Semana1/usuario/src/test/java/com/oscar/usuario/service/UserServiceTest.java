package com.oscar.usuario.service;

import com.oscar.usuario.dto.UserDto;
import com.oscar.usuario.factory.FactoryUserDataTest;
import com.oscar.usuario.mapper.UserMapper;
import com.oscar.usuario.model.User;
import com.oscar.usuario.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    IUserRepository userRepository;
    @Mock
    UserMapper userMapper;

    @Test
    void mustSaveAUser() {
        //Given
        //yo coo usuario hago la solictud para guardar un usuario
        User expectedUser = FactoryUserDataTest.getUser();
        UserDto userDto = FactoryUserDataTest.getUserDto();

        //When
        //le envio los valores correctamente
        when(userRepository.findByUserEmail(anyString())).thenReturn(Optional.empty());
        when(userMapper.toUser(any())).thenReturn(expectedUser);

        userService.saveUser(userDto);
        //Then
        //el sistema e guarda un nuevo usuario
        verify(userRepository).save(any(User.class));
    }

    @Test
    void deleteUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void getUserByEmail() {
    }
}