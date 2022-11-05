package com.rutas.signup.infraestructure.output.jpa.adapter;

import com.rutas.signup.domain.model.User;
import com.rutas.signup.domain.spi.IUserPersistencePort;
import com.rutas.signup.infraestructure.configuration.Cognito;
import com.rutas.signup.infraestructure.exception.UserAlreadyExistsException;
import com.rutas.signup.infraestructure.exception.UserNotFoundException;
import com.rutas.signup.infraestructure.output.client.ICognitoClient;
import com.rutas.signup.infraestructure.output.jpa.entity.UserEntity;
import com.rutas.signup.infraestructure.output.jpa.mapper.IUserEntityMapper;
import com.rutas.signup.infraestructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final ICognitoClient cognitoClient;
    private final IUserEntityMapper userEntityMapper;

    @Override
    public void saveUser(User user) {
        if (userRepository.findByUserEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        Cognito cognitoAnswer = cognitoClient.Signup().getBody();
        int beginIndex = cognitoAnswer.getBody().indexOf("Data") + 5;
        int endIndex = cognitoAnswer.getBody().indexOf("Message") - 6;
        String username = cognitoAnswer.getBody().substring(beginIndex, endIndex);
        UserEntity userEntity = userEntityMapper.toUserEntity(user);
        userEntity.setUsername(username);
        userRepository.save(userEntityMapper.toUserEntity(user));
    }


    @Override
    public User findUserByEmail(String userEmail) {
        UserEntity userInDB = userRepository.findByUserEmail(userEmail).orElseThrow(UserNotFoundException::new);
        return userEntityMapper.toUser(userInDB);
    }
}
