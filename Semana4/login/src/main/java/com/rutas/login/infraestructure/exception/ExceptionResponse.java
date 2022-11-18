package com.rutas.login.infraestructure.exception;

public enum ExceptionResponse {

    PASSWORD_INCORRECT("Contraseña incorrecta"),
    CONNECT_EXCEPTION("Fallo la comunicacion con el servicio "),
    FEIGN_EXCEPTION("Usuario no registrado");



    private final String  message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}