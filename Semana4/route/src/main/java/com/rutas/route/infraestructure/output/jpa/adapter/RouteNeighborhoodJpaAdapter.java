package com.rutas.route.infraestructure.output.jpa.adapter;

import com.rutas.route.domain.model.RouteNeighborhood;
import com.rutas.route.domain.spi.IRouteNeighborhoodPersistencePort;
import com.rutas.route.infraestructure.exception.RouteNeighborhoodAlreadyExistsException;
import com.rutas.route.infraestructure.exception.RouteNeighborhoodNotFoundException;
import com.rutas.route.infraestructure.output.jpa.entity.RouteNeighborhoodEntity;
import com.rutas.route.infraestructure.output.jpa.mapper.RouteNeighborhoodEntityMapper;
import com.rutas.route.infraestructure.output.jpa.repository.IRouteNeighborhoodRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RouteNeighborhoodJpaAdapter implements IRouteNeighborhoodPersistencePort {

    private final IRouteNeighborhoodRepository routeNeighborhoodRepository;
    private final RouteNeighborhoodEntityMapper routeNeighborhoodEntityMapper;
    @Override
    public void saveRouteNeighborhood(RouteNeighborhood routeNeighborhood) {
        List<RouteNeighborhoodEntity> routeNeighborhoods = routeNeighborhoodRepository.findByRouteId(routeNeighborhood.getRouteId());
        for (RouteNeighborhoodEntity routeNeighborhoodEntity : routeNeighborhoods) {
            if (routeNeighborhoodEntity.getNeighborhoodId().equals(routeNeighborhood.getNeighborhoodId())) {
                throw new RouteNeighborhoodAlreadyExistsException();
            }
        }
        routeNeighborhoodRepository.save(routeNeighborhoodEntityMapper.toRouteNeighborhoodEntity(routeNeighborhood));
    }

    @Override
    public void updateRouteNeighborhood(RouteNeighborhood routeNeighborhood) {

    }

    @Override
    public void deleteRouteNeighborhoodByRoute(Long routeId) {
        if (routeNeighborhoodRepository.findByRouteId(routeId).isEmpty()) {
            throw new RouteNeighborhoodNotFoundException();
        }
        routeNeighborhoodRepository.deleteByRouteId(routeId);
    }

    @Override
    public List<RouteNeighborhood> getAllRouteNeighborhoods() {
        return routeNeighborhoodEntityMapper.toRouteNeighborhoodList(routeNeighborhoodRepository.findAll());
    }

    @Override
    public List<RouteNeighborhood> findRouteNeighborhoodByRoute(Long routeId) {
        return routeNeighborhoodEntityMapper.toRouteNeighborhoodList(routeNeighborhoodRepository.findByRouteId(routeId));
    }
}

