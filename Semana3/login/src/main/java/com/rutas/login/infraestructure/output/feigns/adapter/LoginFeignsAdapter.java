package com.rutas.login.infraestructure.output.feigns.adapter;

import com.rutas.login.domain.model.Login;
import com.rutas.login.domain.spi.ILoginPersistancePort;
import com.rutas.login.infraestructure.output.client.CognitoLoginClient;
import com.rutas.login.infraestructure.output.client.SignupClient;
import com.rutas.login.infraestructure.dto.CognitoLoginResponse;
import com.rutas.login.infraestructure.dto.UserResponse;
import com.rutas.login.infraestructure.exception.PasswordIncorrectException;
import com.rutas.login.infraestructure.output.feigns.mapper.LoginEntityMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LoginFeignsAdapter implements ILoginPersistancePort {

    private final CognitoLoginClient cognitoLoginClient;
    private final SignupClient signupClient;
    private final LoginEntityMapper loginEntityMapper;

    @Override
    public String generateToken(Login login) {

        UserResponse user = signupClient.getUserFromDBByEmail(login.getEmail()).getBody();
        CognitoLoginResponse cognitoLoginResponseAnswer;
        if (user.getPassword().equals(login.getPassword())) {
            cognitoLoginResponseAnswer = cognitoLoginClient.Login(loginEntityMapper.toLoginEntity(user.getUsername(), login)).getBody();
        } else {
            throw new PasswordIncorrectException();
        }
        String[] body = cognitoLoginResponseAnswer.getBody();
        String loginAnswer = "El idToken del usuario es: " + (body[3].substring(11, body[3].length() - 1));
        return loginAnswer;
    }
}
