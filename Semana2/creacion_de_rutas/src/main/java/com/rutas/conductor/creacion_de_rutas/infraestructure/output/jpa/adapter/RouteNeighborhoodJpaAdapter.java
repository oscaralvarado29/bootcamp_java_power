package com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.adapter;

import com.rutas.conductor.creacion_de_rutas.domain.model.RouteNeighborhood;
import com.rutas.conductor.creacion_de_rutas.domain.spi.IRouteNeighborhoodPersistencePort;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.mapper.IRouteNeighborhoodEntityMapper;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.repository.IRouteNeighborhoodRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RouteNeighborhoodJpaAdapter implements IRouteNeighborhoodPersistencePort {

    private final IRouteNeighborhoodRepository routeNeighborhoodRepository;
    private final IRouteNeighborhoodEntityMapper routeNeighborhoodEntityMapper;
    @Override
    public void saveRouteNeighborhood(RouteNeighborhood routeNeighborhood) {

    }

    @Override
    public void updateRouteNeighborhood(RouteNeighborhood routeNeighborhood) {

    }

    @Override
    public void deleteRouteNeighborhoodByRoute(Long routeId) {

    }

    @Override
    public RouteNeighborhood getRouteNeighborhood(Long routeNeighborhoodId) {
        return null;
    }

    @Override
    public List<RouteNeighborhood> getAllRouteNeighborhoods() {
        return null;
    }

    @Override
    public List<RouteNeighborhood> findRouteNeighborhoodByRoute(Long routeId) {
        return null;
    }
}
