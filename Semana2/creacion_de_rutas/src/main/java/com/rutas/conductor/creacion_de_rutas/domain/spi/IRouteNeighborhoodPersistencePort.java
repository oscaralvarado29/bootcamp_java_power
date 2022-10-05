package com.rutas.conductor.creacion_de_rutas.domain.spi;

import com.rutas.conductor.creacion_de_rutas.domain.model.RouteNeighborhood;

import java.util.List;

public interface IRouteNeighborhoodPersistencePort {
    void saveRouteNeighborhood( RouteNeighborhood routeNeighborhood );
    void updateRouteNeighborhood( RouteNeighborhood routeNeighborhood );
    void deleteRouteNeighborhood(Long routeNeighborhoodId);
    RouteNeighborhood getRouteNeighborhood(Long routeNeighborhoodId);
    List<RouteNeighborhood> getAllRouteNeighborhoods();

}
