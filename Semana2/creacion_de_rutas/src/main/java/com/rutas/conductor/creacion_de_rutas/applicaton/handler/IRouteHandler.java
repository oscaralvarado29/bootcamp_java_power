package com.rutas.conductor.creacion_de_rutas.applicaton.handler;

import com.rutas.conductor.creacion_de_rutas.applicaton.dto.RouteRequest;
import com.rutas.conductor.creacion_de_rutas.applicaton.dto.RouteResponse;

import java.util.List;

public interface IRouteHandler {
    void saveRouteInDB(RouteRequest routeRequest);
    List<RouteResponse> getAllRoutesFromDB();
    RouteResponse getRouteFromDB(Long id);
    void deleteRouteInDB(String routeName);
    void updateRouteInDB(RouteRequest routeRequest);

}
