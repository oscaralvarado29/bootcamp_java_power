package com.rutas.signup.infraestructure.exception;

public enum ExceptionResponse {
    
    USER_NOT_FOUND("No se encontró el usuario"),
    USER_ALREADY_EXISTS("El usuario ya existe"),
    MISSING_MANDATORY_DATA("Todos los campos son obligatorios"),
    PASSWORD_INVALID_FORMAT("La contraseña no cumple con el formato requerido");

    private final String  message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
