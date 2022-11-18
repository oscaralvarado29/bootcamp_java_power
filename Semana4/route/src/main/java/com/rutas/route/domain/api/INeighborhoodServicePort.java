package com.rutas.route.domain.api;

import com.rutas.route.domain.model.Neighborhood;

import java.util.List;

public interface INeighborhoodServicePort {
    Neighborhood getNeighborhood(Long neighborhoodId);
    List<Neighborhood> getAllNeighborhoods();
}
