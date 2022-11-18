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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor
public class LoginFeignsAdapter implements ILoginPersistancePort {

    private final CognitoLoginClient cognitoLoginClient;
    private final SignupClient signupClient;
    private final LoginEntityMapper loginEntityMapper;

    @Override
    public String generateToken(Login login) {

        UserResponse user = signupClient.getUserFromDBByEmail(login.getEmail()).getBody();
        ResponseEntity<CognitoLoginResponse> cognitoLoginResponseAnswer;
        HttpStatus statusCode ;
        if (user.getPassword().equals(login.getPassword())) {
            cognitoLoginResponseAnswer = cognitoLoginClient.Login(loginEntityMapper.toLoginEntity(user.getUsername(), login));
        } else {
            throw new PasswordIncorrectException();
        }
        statusCode = cognitoLoginResponseAnswer.getStatusCode();

        if (statusCode == HttpStatus.OK) {
            String[] body = cognitoLoginResponseAnswer.getBody().getBody();
            String loginAnswer = "El idToken del usuario es: " + (body[3].substring(11, body[3].length() - 1));
            return loginAnswer;
        } else {
            if (statusCode == HttpStatus.NOT_FOUND) {
                throw new RuntimeException("Error al consultar el usuario");
            } else {
                throw new RuntimeException("Error al councarse conel servicio");
            }
        }
    }
}
