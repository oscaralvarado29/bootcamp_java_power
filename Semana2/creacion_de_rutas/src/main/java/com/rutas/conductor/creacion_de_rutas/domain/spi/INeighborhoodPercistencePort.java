package com.rutas.conductor.creacion_de_rutas.domain.spi;

import com.rutas.conductor.creacion_de_rutas.domain.model.Neighborhood;

import java.util.List;

public interface INeighborhoodPercistencePort {
    void saveNeighborhood(Neighborhood neighborhood);
    void updateNeighborhood(Neighborhood neighborhood);
    void deleteNeighborhood(Long neighborhoodId);
    Neighborhood getNeighborhood(Long neighborhoodId);
    List<Neighborhood> getAllNeighborhoods();

}
