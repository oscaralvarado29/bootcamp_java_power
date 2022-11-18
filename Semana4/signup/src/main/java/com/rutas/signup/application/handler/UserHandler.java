package com.rutas.signup.application.handler;

import com.rutas.signup.application.dto.UserRequest;
import com.rutas.signup.application.dto.UserResponse;
import com.rutas.signup.application.mapper.UserRequestMapper;
import com.rutas.signup.application.mapper.UserResponseMapper;
import com.rutas.signup.domain.api.IUserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class UserHandler  implements IUserHandler {
    private final IUserServicePort userServicePort;
    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;


    @Override
    public void saveUserInDB(UserRequest userRequest) {
        userServicePort.saveUser(userRequestMapper.toUser(userRequest));
    }

    @Override
    public UserResponse getUserFromDBByEmail(String email) {
        return userResponseMapper.toUserResponse(userServicePort.findUserByEmail(email));
    }

}

