package com.rutas.route.domain.api;

import com.rutas.route.domain.model.RouteNeighborhood;

import java.util.List;

public interface IRouteNeighborhoodServicePort {
    void saveRouteNeighborhood(List<RouteNeighborhood> routeNeighborhood) ;
    void updateRouteNeighborhood(RouteNeighborhood routeNeighborhood);
    void deleteRouteNeighborhoodByRoute(Long routeId);
    List<RouteNeighborhood> getAllRouteNeighborhoods();
    List<RouteNeighborhood> findRouteNeighborhoodByRoute(Long routeId);
}
