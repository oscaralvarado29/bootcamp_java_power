package com.rutas.conductor.creacion_de_rutas.domain.spi;

import com.rutas.conductor.creacion_de_rutas.domain.model.Route;

import java.util.List;

public interface IRoutePersistencePort {
    void saveRoute(Route route);
    void updateRoute(Route route);
    void deleteRoute(Long routeId);
    Route getRoute(Long routeId);
    List<Route> getAllRoutes();

}
