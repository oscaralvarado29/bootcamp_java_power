package com.rutas.neighborhood.domain.spi;

import com.rutas.neighborhood.domain.model.Neighborhood;

import java.util.List;

public interface INeighborhoodPersistencePort {
    void saveNeighborhood(Neighborhood neighborhood);
    void updateNeighborhood(Neighborhood neighborhood);
    void deleteNeighborhood(String neighborhoodName);
    Neighborhood getNeighborhood(Long neighborhoodId);
    Neighborhood findNeighborhoodByName(String neighborhoodName);
    List<Neighborhood> getAllNeighborhoods();
}
