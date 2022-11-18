package com.rutas.neighborhoodTraveler.domain.usecase;

import com.rutas.neighborhoodTraveler.domain.api.NeighborhoodTravelerServicePort;
import com.rutas.neighborhoodTraveler.domain.model.NeighborhoodTraveler;
import com.rutas.neighborhoodTraveler.domain.spi.NeighborhoodTravelerPersistancePort;

import java.util.List;

public class NeighborhoodTravelerUseCase implements NeighborhoodTravelerServicePort {

    private NeighborhoodTravelerPersistancePort neighborhoodTravelerPersistancePort;

    public NeighborhoodTravelerUseCase(NeighborhoodTravelerPersistancePort neighborhoodTravelerPersistancePort) {
        this.neighborhoodTravelerPersistancePort = neighborhoodTravelerPersistancePort;
    }

    @Override
    public List<NeighborhoodTraveler> getAllNeighborhoods() {
        return neighborhoodTravelerPersistancePort.getAllNeighborhoods();
    }
}
