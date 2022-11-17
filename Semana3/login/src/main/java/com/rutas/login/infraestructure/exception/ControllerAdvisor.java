package com.rutas.login.infraestructure.exception;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.ConnectException;
import java.util.Collections;
import java.util.Map;

@ControllerAdvice()
public class ControllerAdvisor {
    private static final String MESSAGE = "message";

    @ExceptionHandler(PasswordIncorrectException.class)
    public ResponseEntity<Map<String, String>> passwordIncorrect(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap(MESSAGE, ExceptionResponse.PASSWORD_INCORRECT.getMessage()));
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<Map<String, String>> feignException(FeignException feignException){
        if(feignException.status() == 404){
            String message = ExceptionResponse.FEIGN_EXCEPTION.getMessage();
            String email = (feignException.getMessage().substring(feignException.getMessage().indexOf("user")+5, feignException.getMessage().indexOf("com")+3)).replace("%40", "@");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap(MESSAGE, message.substring(0,8) + email + message.substring(7)));
        }else {
            if (feignException.status() == -1) {
                String[] messageException = feignException.getMessage().split("/");
                return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap(MESSAGE, ExceptionResponse.CONNECT_EXCEPTION.getMessage()+messageException[3]));
            }else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap(MESSAGE, feignException.getMessage()));
            }
        }
    }
}
