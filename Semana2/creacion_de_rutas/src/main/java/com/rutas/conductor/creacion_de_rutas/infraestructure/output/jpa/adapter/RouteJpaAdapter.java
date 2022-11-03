package com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.adapter;

import com.rutas.conductor.creacion_de_rutas.domain.model.Route;
import com.rutas.conductor.creacion_de_rutas.domain.spi.IRoutePersistencePort;
import com.rutas.conductor.creacion_de_rutas.infraestructure.exception.RouteAlreadyExistsException;
import com.rutas.conductor.creacion_de_rutas.infraestructure.exception.RouteNameNotPresentException;
import com.rutas.conductor.creacion_de_rutas.infraestructure.exception.RouteNotFoundException;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.entity.RouteEntity;
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
        if (routeRepository.findByRouteName(route.getRouteName()).isPresent()) {
            throw new RouteAlreadyExistsException();
        }
        routeRepository.save(routeEntityMapper.toRouteEntity(route));
    }

    @Override
    public void updateRoute(Route route) {
        if (route.getRouteName()!= null){
            RouteEntity routeToUpdate = routeRepository.findByRouteName(route.getRouteName()).orElseThrow(RouteNotFoundException::new);
            if (route.getRouteName() != null) {
                routeToUpdate.setRouteName(route.getRouteName());
            }
            if (route.getDescription() != null) {
                routeToUpdate.setDescription(route.getDescription());
            }
            if (route.getQuota() != null) {
                routeToUpdate.setQuota(route.getQuota());
            }
            if (route.getConductorId() != null) {
                routeToUpdate.setConductorId(route.getConductorId());
            }
            routeRepository.save(routeToUpdate);
        } else {
            throw new RouteNameNotPresentException();
        }
    }

    @Override
    public void deleteRoute(String routeName) {
        if (routeRepository.findByRouteName(routeName).isEmpty()) {
            throw new RouteNotFoundException();
        }
        routeRepository.deleteByRouteName(routeName);
    }

    @Override
    public Route findRouteByName(String routeName) {
        RouteEntity routeInDB = routeRepository.findByRouteName(routeName).orElseThrow(RouteNotFoundException::new);
        return routeEntityMapper.toRoute(routeInDB);
    }

    @Override
    public List<Route> getAllRoutes() {
        return routeEntityMapper.toRouteList(routeRepository.findAll());
    }
}
