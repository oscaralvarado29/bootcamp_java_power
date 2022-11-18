package com.rutas.route.application.handler;

import com.rutas.route.application.dto.RouteRequest;
import com.rutas.route.application.dto.RouteRequestClient;
import com.rutas.route.application.dto.RouteResponse;

import java.util.List;

public interface IRouteHandler {
    void saveRouteInDB(RouteRequestClient routeRequestClient);
    List<RouteResponse> getAllRoutesFromDB();
    RouteResponse getRouteFromDBByName(String routeName);
    void deleteRouteInDB(String routeName);
    void deleteTravelInDB(String routeName, String travelDate);
    void updateRouteInDB(RouteRequest routeRequest);
}
