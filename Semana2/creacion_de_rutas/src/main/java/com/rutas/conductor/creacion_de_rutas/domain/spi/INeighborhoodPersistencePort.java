package com.rutas.conductor.creacion_de_rutas.domain.spi;

import com.rutas.conductor.creacion_de_rutas.domain.model.Neighborhood;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.entity.NeighborhoodEntity;

import java.util.List;
import java.util.Optional;

public interface INeighborhoodPersistencePort {
    void saveNeighborhood(Neighborhood neighborhood);
    void updateNeighborhood(Neighborhood neighborhood);
    void deleteNeighborhood(String neighborhoodName);
    Neighborhood getNeighborhood(Long neighborhoodId);
    Neighborhood findByName(String neighborhoodName);
    List<Neighborhood> getAllNeighborhoods();

}
