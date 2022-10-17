package com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.adapter;

import com.rutas.conductor.creacion_de_rutas.domain.model.RouteNeighborhood;
import com.rutas.conductor.creacion_de_rutas.domain.spi.IRouteNeighborhoodPersistencePort;
import com.rutas.conductor.creacion_de_rutas.infraestructure.exception.RouteNeighborhoodAlreadyExistsException;
import com.rutas.conductor.creacion_de_rutas.infraestructure.exception.RouteNeighborhoodNotFoundException;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.entity.RouteNeighborhoodEntity;
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
    public RouteNeighborhood getRouteNeighborhood(Long routeNeighborhoodId) {
        RouteNeighborhoodEntity routeNeighborhoodInDB = routeNeighborhoodRepository.findById(routeNeighborhoodId).orElseThrow(RouteNeighborhoodNotFoundException::new);
        return routeNeighborhoodEntityMapper.toRouteNeighborhood(routeNeighborhoodInDB);
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
