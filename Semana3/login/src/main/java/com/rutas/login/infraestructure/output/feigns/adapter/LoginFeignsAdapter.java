package com.rutas.login.infraestructure.output.feigns.adapter;

import com.rutas.login.domain.model.Login;
import com.rutas.login.domain.spi.ILoginPersistancePort;
import com.rutas.login.infraestructure.output.client.CognitoClient;
import com.rutas.login.infraestructure.output.client.SignupClient;
import com.rutas.login.infraestructure.dto.Cognito;
import com.rutas.login.infraestructure.dto.UserResponse;
import com.rutas.login.infraestructure.exception.PasswordIncorrectException;
import com.rutas.login.infraestructure.exception.UserNotRegisterException;
import com.rutas.login.infraestructure.output.feigns.mapper.LoginEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor
public class LoginFeignsAdapter implements ILoginPersistancePort {

    private final CognitoClient cognitoClient;
    private final SignupClient signupClient;
    private final LoginEntityMapper loginEntityMapper;

    @Override
    public String generateToken(Login login) {
        ResponseEntity<UserResponse> user= signupClient.getUserFromDBByEmail(login.getEmail());
        Cognito cognitoAnswer;
        if (user.getBody().getUsername() != null) {
            if (user.getBody().getPassword().equals(login.getPassword())) {
                cognitoAnswer = cognitoClient.Login(loginEntityMapper.toLoginEntity(user.getBody().getUsername(),login)).getBody();
            } else {
                throw new PasswordIncorrectException();
            }
        } else {
            throw new UserNotRegisterException();
        }
        String[] body = cognitoAnswer.getBody();
        String loginAnswer = "El idToken del usuaro es" + body[2];
        return loginAnswer;
    }
}
