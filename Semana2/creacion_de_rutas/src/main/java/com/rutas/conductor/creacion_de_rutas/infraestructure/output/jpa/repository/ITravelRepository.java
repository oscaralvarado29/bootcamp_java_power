package com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.repository;

import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.entity.TravelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ITravelRepository extends JpaRepository<TravelEntity, Long> {
    List<TravelEntity> findByRouteId(Long routeId);
    void deleteByRouteId(Long routeId);

    Optional<TravelEntity> findByRouteIdAndDate(Long routeId, String date);

    void deleteByRouteIdAndDate(Long routeId, String date);
}
