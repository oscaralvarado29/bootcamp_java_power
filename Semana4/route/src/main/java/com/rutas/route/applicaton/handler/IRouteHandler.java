package com.rutas.route.applicaton.handler;

import com.rutas.route.applicaton.dto.RouteRequest;
import com.rutas.route.applicaton.dto.RouteRequestClient;
import com.rutas.route.applicaton.dto.RouteResponse;

import java.util.List;

public interface IRouteHandler {
    void saveRouteInDB(RouteRequestClient routeRequestClient);
    List<RouteResponse> getAllRoutesFromDB();
    RouteResponse getRouteFromDBByName(String routeName);
    void deleteRouteInDB(String routeName);
    void deleteTravelInDB(String routeName, String travelDate);
    void updateRouteInDB(RouteRequest routeRequest);
}
