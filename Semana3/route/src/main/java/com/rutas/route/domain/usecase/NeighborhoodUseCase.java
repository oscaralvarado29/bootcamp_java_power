package com.rutas.route.domain.usecase;

import com.rutas.route.domain.api.INeighborhoodServicePort;
import com.rutas.route.domain.model.Neighborhood;
import com.rutas.route.domain.spi.INeighborhoodPersistancePort;

import java.util.List;

public class NeighborhoodUseCase implements INeighborhoodServicePort {
    private final INeighborhoodPersistancePort neighborhoodPersistancePort;

    public NeighborhoodUseCase(INeighborhoodPersistancePort neighborhoodPersistancePort) {
        this.neighborhoodPersistancePort = neighborhoodPersistancePort;
    }

    /**
     * @param neighborhoodId the id of the neighborhood to be found
     * @return the neighborhood found
     */
    @Override
    public Neighborhood getNeighborhood(Long neighborhoodId) {
        return neighborhoodPersistancePort.getNeighborhood(neighborhoodId);
    }

    @Override
    public List<Neighborhood> getAllNeighborhoods() {
        return neighborhoodPersistancePort.getAllNeighborhoods();
    }
}
