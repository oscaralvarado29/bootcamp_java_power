package com.rutas.conductor.creacion_de_rutas.domain.api;

import com.rutas.conductor.creacion_de_rutas.domain.model.Neighborhood;

import java.util.List;

public interface INeighborhoodServicePort {
    void saveNeighborhood(Neighborhood neighborhood);
    void updateNeighborhood(Neighborhood neighborhood);
    void deleteNeighborhood(String neighborhoodName);
    Neighborhood getNeighborhood(Long neighborhoodId);
    List<Neighborhood> getAllNeighborhoods();
}
