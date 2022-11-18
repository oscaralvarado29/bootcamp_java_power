package com.rutas.route.domain.spi;

import com.rutas.route.domain.model.RouteNeighborhood;

import java.util.List;

public interface IRouteNeighborhoodPersistencePort {
    void saveRouteNeighborhood( RouteNeighborhood routeNeighborhood );
    void updateRouteNeighborhood( RouteNeighborhood routeNeighborhood );
    void deleteRouteNeighborhoodByRoute(Long routeId);
    List<RouteNeighborhood> getAllRouteNeighborhoods();
    List<RouteNeighborhood> findRouteNeighborhoodByRoute(Long routeId);
}
