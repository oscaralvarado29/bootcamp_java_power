package com.rutas.signup.infraestructure.output.jpa.adapter;

import com.rutas.signup.domain.model.User;
import com.rutas.signup.domain.spi.IUserPersistencePort;
import com.rutas.signup.infraestructure.dto.Cognito;
import com.rutas.signup.infraestructure.exception.UserAlreadyExistsException;
import com.rutas.signup.infraestructure.exception.UserNotFoundException;
import com.rutas.signup.infraestructure.output.client.ICognitoClient;
import com.rutas.signup.infraestructure.output.jpa.entity.UserEntity;
import com.rutas.signup.infraestructure.output.jpa.mapper.IUserEntityMapper;
import com.rutas.signup.infraestructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final ICognitoClient cognitoClient;
    private final IUserEntityMapper userEntityMapper;

    @Override
    public void saveUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        Optional<Cognito> cognitoAnswer = Optional.ofNullable(cognitoClient.Signup(user).getBody());
        if (cognitoAnswer.isPresent()) {
            String[] body = cognitoAnswer.get().getBody();
            int endIndex = body[1].length() - 1;
            String username = body[1].substring(8, endIndex);
            UserEntity userEntity = userEntityMapper.toUserEntity(user);
            userEntity.setUsername(username);
            userRepository.save(userEntity);
        }
    }


    @Override
    public User findUserByEmail(String email) {
        UserEntity userInDB = userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
        return userEntityMapper.toUser(userInDB);
    }
}
