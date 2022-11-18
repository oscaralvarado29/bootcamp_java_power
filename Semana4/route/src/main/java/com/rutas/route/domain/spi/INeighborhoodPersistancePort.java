package com.rutas.route.domain.spi;

import com.rutas.route.domain.model.Neighborhood;

import java.util.List;

public interface INeighborhoodPersistancePort {
    Neighborhood getNeighborhood(Long neighborhoodId);
    List<Neighborhood> getAllNeighborhoods();
}
