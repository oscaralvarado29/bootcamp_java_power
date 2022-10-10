package com.rutas.conductor.creacion_de_rutas.domain.api;

import com.rutas.conductor.creacion_de_rutas.domain.model.Route;

import java.util.List;

public interface IRouteServicePort {
    Route saveRoute(Route route);
    void updateRoute(Route route);
    Route findRouteByName(String routeName);
    List<Route> getAllRoutes();

}
