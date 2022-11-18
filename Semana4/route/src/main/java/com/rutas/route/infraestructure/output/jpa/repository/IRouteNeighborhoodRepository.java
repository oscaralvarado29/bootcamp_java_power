package com.rutas.route.infraestructure.output.jpa.repository;

import com.rutas.route.infraestructure.output.jpa.entity.RouteNeighborhoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRouteNeighborhoodRepository extends JpaRepository<RouteNeighborhoodEntity, Long> {
    List<RouteNeighborhoodEntity> findByRouteId(Long routeId);
    void deleteByRouteId(Long routeId);
}
