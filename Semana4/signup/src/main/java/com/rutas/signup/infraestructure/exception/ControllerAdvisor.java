package com.rutas.signup.infraestructure.exception;

import com.rutas.signup.domain.exception.MissingMandatoryDataException;
import com.rutas.signup.domain.exception.PasswordInvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice()
public class ControllerAdvisor {
    private static final String MESSAGE = "message";

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, String>> userNotFound(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap(MESSAGE, ExceptionResponse.USER_NOT_FOUND.getMessage()));
    }
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> userAlreadyExists(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap(MESSAGE, ExceptionResponse.USER_ALREADY_EXISTS.getMessage()));
    }
    
    @ExceptionHandler(MissingMandatoryDataException.class)
    public ResponseEntity<Map<String, String>> missingMandatoryData(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap(MESSAGE, ExceptionResponse.MISSING_MANDATORY_DATA.getMessage()));
    }
    @ExceptionHandler(PasswordInvalidFormatException.class)
    public ResponseEntity<Map<String, String>> passwordInvalidFormat(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap(MESSAGE, ExceptionResponse.PASSWORD_INVALID_FORMAT.getMessage()));
    }
}
