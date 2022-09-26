package com.oscar.usuario.exceptionhandler;

import com.oscar.usuario.controller.UserController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice()
public class ControllerAdvisor {

    private static final String MESSAGE = "message";

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, String>> userNotFound(UserNotFoundException userNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap(MESSAGE, ExceptionResponse.USER_NOT_FOUND.getMessage()));
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> userAlreadyExists(UserAlreadyExistsException userAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap(MESSAGE, ExceptionResponse.USER_ALREADY_EXISTS.getMessage()));
    }

    @ExceptionHandler(EmailNotPresentException.class)
    public ResponseEntity<Map<String, String>> emailNotPresent(EmailNotPresentException emailNotPresentException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap(MESSAGE, ExceptionResponse.EMAIL_NOT_PRESENT.getMessage()));
    }

    @ExceptionHandler(EmailInvaldFormatException.class)
    public ResponseEntity<Map<String, String>> emailInvalidFormat(EmailInvaldFormatException emailInvaldFormatException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap(MESSAGE, ExceptionResponse.EMAIL_INVALID_FORMAT.getMessage()));
    }

    @ExceptionHandler(MissingMandatoryDataException.class)
    public ResponseEntity<Map<String, String>> missingMandatoryData(MissingMandatoryDataException missingMandatoryDataException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap(MESSAGE, ExceptionResponse.MISSING_MANDATORY_DATA.getMessage()));
    }

    @ExceptionHandler(PasswordNotValidException.class)
    public ResponseEntity<Map<String, String>> passwordNotValid(PasswordNotValidException passwordNotValidException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap(MESSAGE, ExceptionResponse.PASSWORD_NOT_VALID.getMessage()));
    }
}
