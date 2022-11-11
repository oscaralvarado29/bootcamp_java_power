package com.rutas.login.infraestructure.exception;

public enum ExceptionResponse {

    PASSWORD_INCORRECT("Contraseña incorrecta"),
    USER_NOT_REGISTER("Usuario no registrado");

    private final String  message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}