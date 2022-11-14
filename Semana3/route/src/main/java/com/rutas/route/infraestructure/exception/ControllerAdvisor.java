package com.rutas.route.infraestructure.exception;

import com.rutas.route.domain.exception.DateAndHourNotPresentException;
import com.rutas.route.domain.exception.QuotaNotValidException;
import com.rutas.route.domain.exception.RepeatedNeighborhoodsException;
import feign.FeignException;
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

    @ExceptionHandler(DateAndHourNotPresentException.class)
    public ResponseEntity<Map<String, String>> dateAndHourNotPresent( ){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap(MESSAGE, ExceptionResponse.DATE_AND_HOUR_NOT_PRESENT.getMessage()));
    }
    @ExceptionHandler(RouteNotFoundException.class)
    public ResponseEntity<Map<String, String>> routeNotFound(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap(MESSAGE, ExceptionResponse.ROUTE_NOT_FOUND.getMessage()));
    }
    @ExceptionHandler(RouteAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> routeAlreadyExists(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap(MESSAGE, ExceptionResponse.ROUTE_ALREADY_EXISTS.getMessage()));
    }
    @ExceptionHandler(RouteNameNotPresentException.class)
    public ResponseEntity<Map<String, String>> routeNameNotPresent(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap(MESSAGE, ExceptionResponse.ROUTENAME_NOT_PRESENT.getMessage()));
    }
    @ExceptionHandler(RouteNeighborhoodNotFoundException.class)
    public ResponseEntity<Map<String, String>> routeNeighborhoodNotFound(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap(MESSAGE, ExceptionResponse.ROUTENEIGHBORHOOD_NOT_FOUND.getMessage()));
    }
    @ExceptionHandler(RouteNeighborhoodAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> routeNeighborhoodAlreadyExists(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap(MESSAGE, ExceptionResponse.ROUTENEIGHBORHOOD_ALREADY_EXISTS.getMessage()));
    }
    @ExceptionHandler(TravelAlreadyExistException.class)
    public ResponseEntity<Map<String, String>> travelAlreadyExist(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap(MESSAGE, ExceptionResponse.TRAVEL_ALREADY_EXISTS.getMessage()));
    }
    @ExceptionHandler(TravelNotFoundException.class)
    public ResponseEntity<Map<String, String>> travelNotFound(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap(MESSAGE, ExceptionResponse.TRAVEL_NOT_FOUND.getMessage()));
    }
    @ExceptionHandler(QuotaNotValidException.class)
    public ResponseEntity<Map<String, String>> quotaNotValid(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap(MESSAGE, ExceptionResponse.QUOTA_NOT_VALID.getMessage()));
    }
    @ExceptionHandler(RepeatedNeighborhoodsException.class)
    public ResponseEntity<Map<String, String>> repeatedNeighborhoods(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap(MESSAGE, ExceptionResponse.REPEATED_NEIGHBORHOODS.getMessage()));
    }
    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<Map<String, String>> missingRequestHeader(){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap(MESSAGE, ExceptionResponse.HEADER_AUTHORIZATION_NOT_PRESENT.getMessage()));
    }
    @ExceptionHandler(FeignException.class)
    public ResponseEntity<Map<String, String>> feignException(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap(MESSAGE, ExceptionResponse.FEIGN_EXCEPTION.getMessage()));
    }
}
