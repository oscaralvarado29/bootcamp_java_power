package com.rutas.route.infraestructure.exception;

public enum ExceptionResponse {
    DATE_AND_HOUR_NOT_PRESENT("La fecha y hora de la ruta no pueden ser nulas"),
    QUOTA_NOT_VALID("La cantidad de pasajeros no es válida"),
    REPEATED_NEIGHBORHOODS("Los barrios de las paradas no pueden ser iguales"),
    ROUTE_NOT_FOUND("No se encontró la ruta"),
    ROUTE_ALREADY_EXISTS("La ruta ya existe"),
    ROUTENAME_NOT_PRESENT("El nombre de la ruta no puede ser nulo"),
    ROUTENEIGHBORHOOD_NOT_FOUND("No se encontró paradas de la ruta"),
    ROUTENEIGHBORHOOD_ALREADY_EXISTS("El barrio ya existe"),
    TRAVEL_NOT_FOUND("No se encontró el viaje"),
    TRAVEL_ALREADY_EXISTS("El viaje ya existe"),
    USER_NOT_FOUND("Usuario no se a registrado"),
    CONNECT_EXCEPTION("Fallo la comunicacion con el servicio "),
    HEADER_AUTHORIZATION_NOT_PRESENT("Usuario no autorizado");

    private final String  message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
