package com.rutas.conductor.creacion_de_rutas.domain.spi;

import com.rutas.conductor.creacion_de_rutas.domain.model.RouteNeighborhood;

import java.util.List;

public interface IRouteNeighborhoodPersistencePort {
    void saveRouteNeighborhood( RouteNeighborhood routeNeighborhood );
    void updateRouteNeighborhood( RouteNeighborhood routeNeighborhood );
    void deleteRouteNeighborhoodByRoute(Long routeId);
    List<RouteNeighborhood> getAllRouteNeighborhoods();
    List<RouteNeighborhood> findRouteNeighborhoodByRoute(Long routeId);
}
