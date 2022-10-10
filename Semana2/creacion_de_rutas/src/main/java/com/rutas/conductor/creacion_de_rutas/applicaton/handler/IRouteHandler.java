package com.rutas.conductor.creacion_de_rutas.applicaton.handler;

import com.rutas.conductor.creacion_de_rutas.applicaton.dto.RouteRequest;
import com.rutas.conductor.creacion_de_rutas.applicaton.dto.RouteResponse;

import java.util.List;

public interface IRouteHandler {
    void saveRouteInDB(RouteRequest routeRequest);
    List<RouteResponse> getAllRoutesFromDB();
    RouteResponse getRouteFromDBByName(String routeName);
    void deleteRouteInDB(String routeName);
    void deleteTravelInDB(String routeName, String travelDate);
    void updateRouteInDB(RouteRequest routeRequest);

}
