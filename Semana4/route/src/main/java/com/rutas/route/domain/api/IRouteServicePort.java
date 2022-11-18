package com.rutas.route.domain.api;

import com.rutas.route.domain.model.Route;

import java.util.List;

public interface IRouteServicePort {
    Route saveRoute(Route route);
    void updateRoute(Route route);
    void deleteRoute(String routeName);
    Route findRouteByName(String routeName);
    List<Route> getAllRoutes();
}
