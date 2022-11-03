package com.rutas.conductor.creacion_de_rutas.domain.exceptions;

public class RepeatedNeighborhoodsException extends RuntimeException {
    public RepeatedNeighborhoodsException() {
        super("Repeated neighborhoods");
    }
}
