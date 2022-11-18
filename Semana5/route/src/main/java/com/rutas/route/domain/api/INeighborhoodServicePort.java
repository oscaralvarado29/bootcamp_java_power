package com.rutas.route.domain.api;

import com.rutas.route.domain.model.Neighborhood;

import java.util.List;

public interface INeighborhoodServicePort {
    void saveNeighborhood(Neighborhood neighborhood);
    void updateNeighborhood(Neighborhood neighborhood);
    void deleteNeighborhood(String neighborhoodName);
    Neighborhood getNeighborhood(Long neighborhoodId);
    Neighborhood findNeighborhoodByName(String neighborhoodName);
    List<Neighborhood> getAllNeighborhoods();
}
