package com.rutas.conductor.creacion_de_rutas.domain.factory;

import com.rutas.conductor.creacion_de_rutas.domain.model.Route;

public class FactoryRouteDataTest {
    public static Route getRoute(){
        Route route = new Route();
        route.setRouteId(1L);
        route.setRouteName("Ruta 1");
        route.setDescription("Ruta 1");
        route.setOriginNeighborhood(1L);
        route.setDestinationNeighborhood(2L);
        route.setQuota(3);
        route.setConductorId(1L);
        return route;
    }
}
