package com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.adapter;

import com.rutas.conductor.creacion_de_rutas.domain.model.User;
import com.rutas.conductor.creacion_de_rutas.domain.spi.IUserPersistencePort;
import com.rutas.conductor.creacion_de_rutas.infraestructure.exception.UserNotFoundException;
import com.rutas.conductor.creacion_de_rutas.infraestructure.exception.UserAlreadyExistsException;
import com.rutas.conductor.creacion_de_rutas.infraestructure.exception.UserEmailNotPresentException;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.entity.UserEntity;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.mapper.IUserEntityMapper;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    @Override
    public void saveUser(User user) {
        if (userRepository.findByUserEmail(user.getUserEmail()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        userRepository.save(userEntityMapper.toUserEntity(user));
    }

    @Override
    public void updateUser(User user) {
        if (user.getUserEmail() != null){
            UserEntity userToUpdate = userRepository.findByUserEmail(user.getUserEmail()).orElseThrow(UserNotFoundException::new);
            if (user.getUserName() != null) {
                userToUpdate.setUserName(user.getUserName());
            }
            if (user.getUserSurname() != null) {
                userToUpdate.setUserSurname(user.getUserSurname());
            }
            if (user.getUserPhone() != null) {
                userToUpdate.setUserPhone(user.getUserPhone());
            }
            if (user.getUserAddress() != null) {
                userToUpdate.setUserAddress(user.getUserAddress());
            }
            if (user.getUserPassword() != null) {
                userToUpdate.setUserPassword(user.getUserPassword());
            }
            userRepository.save(userToUpdate);
        } else {
            throw new UserEmailNotPresentException();
        }
    }

    @Override
    public void deleteUser(String userEmail) {
        if (userRepository.findByUserEmail(userEmail).isEmpty()){
            throw new UserNotFoundException();
        }
        userRepository.deleteByUserEmail(userEmail);
    }

    @Override
    public User findByUserEmail(String userEmail) {
        UserEntity userInDB = userRepository.findByUserEmail(userEmail).orElseThrow(UserNotFoundException::new);
        return userEntityMapper.toUser(userInDB);
    }

    @Override
    public User getUser(Long userId) {
        UserEntity userInDB = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        return userEntityMapper.toUser(userInDB);
    }

    @Override
    public List<User> getAllUsers() {
        return userEntityMapper.toUserList(userRepository.findAll());
    }
}
