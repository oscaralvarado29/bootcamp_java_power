package com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.repository;

import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.entity.NeighborhoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface INeighborhoodRepository extends JpaRepository<NeighborhoodEntity, Long> {
    Optional<NeighborhoodEntity> findByNeighborhoodName(String name);
    void deleteByNeighborhoodName(String name);
}
