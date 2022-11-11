package com.rutas.login.application.handler;

import com.rutas.login.application.dto.LoginRequest;
import com.rutas.login.application.mapper.LoginRequestMapper;
import com.rutas.login.domain.api.ILoginServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginHandler implements ILoginHandler {

    private final ILoginServicePort loginServicePort;
    private final LoginRequestMapper loginRequestMapper;
    @Override
    public String generateToken(LoginRequest loginRequest) {
        return loginServicePort.generateToken(loginRequestMapper.toLogin(loginRequest));
    }
}
