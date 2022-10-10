package com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.repository;

import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.entity.TravelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITravelRepository extends JpaRepository<TravelEntity, Long> {
    List<TravelEntity> findByRouteId(Long routeId);
    void deleteByRouteId(Long routeId);
}
