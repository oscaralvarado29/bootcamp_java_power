package com.rutas.conductor.creacion_de_rutas.applicaton.handler;

import com.rutas.conductor.creacion_de_rutas.applicaton.dto.UserRequest;
import com.rutas.conductor.creacion_de_rutas.applicaton.dto.UserResponse;
import com.rutas.conductor.creacion_de_rutas.applicaton.mapper.UserRequestMapper;
import com.rutas.conductor.creacion_de_rutas.applicaton.mapper.UserResponseMapper;
import com.rutas.conductor.creacion_de_rutas.domain.api.IUserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserHandler implements IUserHandler {
    private final IUserServicePort userServicePort;
    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;

    @Override
    public void saveUserInDB(UserRequest userRequest) {
        userServicePort.saveUser(userRequestMapper.toUser(userRequest));
    }

    @Override
    public List<UserResponse> getAllUsersFromDB() {
        return userResponseMapper.toUserResponseList(userServicePort.getAllUsers());
    }

    @Override
    public UserResponse getUserFromDB(Long id) {
        return userResponseMapper.toUserResponse(userServicePort.getUser(id));
    }

    @Override
    public UserResponse getUserFromDBByEmail(String email) {
        return userResponseMapper.toUserResponse(userServicePort.findUserByEmail(email));
    }

    @Override
    public void deleteUserInDB(String email) {
        userServicePort.deleteUser(email);
    }

    @Override
    public void updateUserInDB(UserRequest userRequest) {
        userServicePort.updateUser(userRequestMapper.toUser(userRequest));
    }
}
