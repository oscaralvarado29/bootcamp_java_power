package com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.repository;

import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.entity.RouteNeighborhoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRouteNeighborhoodRepository extends JpaRepository<RouteNeighborhoodEntity, Long> {
    List<RouteNeighborhoodEntity> findByRouteId(Long routeId);
    void deleteByRouteId(Long routeId);
}
