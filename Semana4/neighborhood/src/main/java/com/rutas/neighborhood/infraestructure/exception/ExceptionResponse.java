package com.rutas.neighborhood.infraestructure.exception;

public enum ExceptionResponse {

    NEIGHBORHOOD_NOT_FOUND("No se encontró la barrio"),
    NEIGHBORHOOD_ALREADY_EXISTS("El barrio ya existe"),
    NEIGHBORHOODNAME_NOT_PRESENT("El nombre del barrio no puede ser nulo"),
    HEADER_AUTHORIZATION_NOT_PRESENT("Usuario no autorizado");

    private final String  message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
