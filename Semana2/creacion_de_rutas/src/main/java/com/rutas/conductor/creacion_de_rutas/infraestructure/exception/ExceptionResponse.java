package com.rutas.conductor.creacion_de_rutas.infraestructure.exception;

public enum ExceptionResponse {
    DATE_AND_HOUR_NOT_PRESENT("La fecha y hora de la ruta no pueden ser nulas"),
    NEIGHBORHOOD_NOT_FOUND("No se encontró la barrio"),
    NEIGHBORHOOD_ALREADY_EXISTS("El barrio ya existe"),
    NEIGHBORHOODNAME_NOT_PRESENT("El nombre del barrio no puede ser nulo"),
    USER_NOT_FOUND("No se encontró el usuario"),
    USER_ALREADY_EXISTS("El usuario ya existe"),
    EMAIL_NOT_PRESENT("El email no puede ser nulo"),
    EMAIL_INVALID_FORMAT("El email tiene un formato inválido"),
    MISSING_MANDATORY_DATA("Todos los campos son obligatorios"),
    PASSWORD_INVALID_FORMAT("La contraseña no cumple con el formato requerido"),
    ROUTE_NOT_FOUND("No se encontró la ruta"),
    ROUTE_ALREADY_EXISTS("La ruta ya existe"),
    ROUTENAME_NOT_PRESENT("El nombre de la ruta no puede ser nulo"),
    ROUTENEIGHBORHOOD_NOT_FOUND("No se encontró paradas de la ruta"),
    ROUTENEIGHBORHOOD_ALREADY_EXISTS("El barrio ya existe"),
    TRAVEL_NOT_FOUND("No se encontró el viaje"),
    TRAVEL_ALREADY_EXISTS("El viaje ya existe");

    private final String  message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
