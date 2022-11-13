package com.rutas.neighborhood.infraestructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice()
public class ControllerAdvisor {
    private static final String MESSAGE = "message";

    @ExceptionHandler(NeighborhoodNotFoundException.class)
    public ResponseEntity<Map<String, String>> neighborhoodNotFound( ){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap(MESSAGE, ExceptionResponse.NEIGHBORHOOD_NOT_FOUND.getMessage()));
    }
    @ExceptionHandler(NeighborhoodAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> neighborhoodAlreadyExists(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap(MESSAGE, ExceptionResponse.NEIGHBORHOOD_ALREADY_EXISTS.getMessage()));
    }
    @ExceptionHandler(NeighborhoodNameNotPresentException.class)
    public ResponseEntity<Map<String, String>> neighborhoodNameNotPresent(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap(MESSAGE, ExceptionResponse.NEIGHBORHOODNAME_NOT_PRESENT.getMessage()));
    }
    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<Map<String, String>> missingRequestHeader(){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap(MESSAGE, ExceptionResponse.HEADER_AUTHORIZATION_NOT_PRESENT.getMessage()));
    }
}
