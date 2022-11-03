package com.rutas.conductor.creacion_de_rutas.infraestructure.exception;

import com.rutas.conductor.creacion_de_rutas.domain.exceptions.DateAndHourNotPresentException;
import com.rutas.conductor.creacion_de_rutas.domain.exceptions.EmailInvalidFormatException;
import com.rutas.conductor.creacion_de_rutas.domain.exceptions.EmailNotPresentException;
import com.rutas.conductor.creacion_de_rutas.domain.exceptions.MissingMandatoryDataException;
import com.rutas.conductor.creacion_de_rutas.domain.exceptions.PasswordInvalidFormatException;
import com.rutas.conductor.creacion_de_rutas.domain.exceptions.QuotaNotValidException;
import com.rutas.conductor.creacion_de_rutas.domain.exceptions.RepeatedNeighborhoodsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, String>> userNotFound(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap(MESSAGE, ExceptionResponse.USER_NOT_FOUND.getMessage()));
    }
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> userAlreadyExists(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap(MESSAGE, ExceptionResponse.USER_ALREADY_EXISTS.getMessage()));
    }
    @ExceptionHandler(EmailNotPresentException.class)
    public ResponseEntity<Map<String, String>> emailNotPresent(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap(MESSAGE, ExceptionResponse.EMAIL_NOT_PRESENT.getMessage()));
    }
    @ExceptionHandler(EmailInvalidFormatException.class)
    public ResponseEntity<Map<String, String>> emailInvalidFormat(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap(MESSAGE, ExceptionResponse.EMAIL_INVALID_FORMAT.getMessage()));
    }
    @ExceptionHandler(MissingMandatoryDataException.class)
    public ResponseEntity<Map<String, String>> missingMandatoryData(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap(MESSAGE, ExceptionResponse.MISSING_MANDATORY_DATA.getMessage()));
    }
    @ExceptionHandler(PasswordInvalidFormatException.class)
    public ResponseEntity<Map<String, String>> passwordInvalidFormat(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap(MESSAGE, ExceptionResponse.PASSWORD_INVALID_FORMAT.getMessage()));
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

}
