package com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.adapter;

import com.rutas.conductor.creacion_de_rutas.domain.model.Route;
import com.rutas.conductor.creacion_de_rutas.domain.spi.IRoutePersistencePort;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.mapper.IRouteEntityMapper;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.repository.IRouteRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RouteJpaAdapter implements IRoutePersistencePort {

    private final IRouteRepository routeRepository;
    private final IRouteEntityMapper routeEntityMapper;
    @Override
    public void saveRoute(Route route) {

    }

    @Override
    public void updateRoute(Route route) {

    }

    @Override
    public Route findRouteByName(String routeName) {
        return null;
    }

    @Override
    public List<Route> getAllRoutes() {
        return null;
    }
}
