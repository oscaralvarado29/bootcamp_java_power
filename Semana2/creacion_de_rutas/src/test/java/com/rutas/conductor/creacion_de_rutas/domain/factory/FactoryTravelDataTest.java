package com.rutas.conductor.creacion_de_rutas.domain.factory;

import com.rutas.conductor.creacion_de_rutas.domain.model.Travel;


public class FactoryTravelDataTest {
    public static Travel getTravel() {
        Travel travel = new Travel();
        travel.setTravelId(1L);
        travel.setRouteId(1L);
        travel.setDate("18/12/2022");
        travel.setHour("7:02 am");
        return travel;
    }

}
