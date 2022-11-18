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
     * @param neighborhood the neighborhood to be saved
     */
    @Override
    public void saveNeighborhood(Neighborhood neighborhood) {
        neighborhoodPersistancePort.saveNeighborhood(neighborhood);
    }

    /**
     * @param neighborhood the neighborhood to be updated
     */
    @Override
    public void updateNeighborhood(Neighborhood neighborhood) {
        neighborhoodPersistancePort.updateNeighborhood(neighborhood);
    }


    /**
     * @param neighborhoodName the name of the neighborhood to be deleted
     */
    @Override
    public void deleteNeighborhood(String neighborhoodName) {
        neighborhoodPersistancePort.deleteNeighborhood(neighborhoodName);
    }

    /**
     *
     * @param neighborhoodId the id of the neighborhood to be found
     * @return the neighborhood found
     */
    @Override
    public Neighborhood getNeighborhood(Long neighborhoodId) {
        return neighborhoodPersistancePort.getNeighborhood(neighborhoodId);
    }
    /**
     * @param neighborhoodName the name of the neighborhood to be found
     * @return the neighborhood found
     */
    @Override
    public Neighborhood findNeighborhoodByName(String neighborhoodName) {
        return neighborhoodPersistancePort.findNeighborhoodByName(neighborhoodName);
    }

    /**
     * @return all the neighborhoods
     */
    @Override
    public List<Neighborhood> getAllNeighborhoods() {
        return neighborhoodPersistancePort.getAllNeighborhoods();
    }}
