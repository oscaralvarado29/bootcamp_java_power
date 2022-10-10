package com.rutas.conductor.creacion_de_rutas.domain.usecase;

import com.rutas.conductor.creacion_de_rutas.domain.api.INeighborhoodServicePort;
import com.rutas.conductor.creacion_de_rutas.domain.model.Neighborhood;
import com.rutas.conductor.creacion_de_rutas.domain.spi.INeighborhoodPersistencePort;

import java.util.List;

public class NeighborhoodUseCase implements INeighborhoodServicePort {
    private final INeighborhoodPersistencePort neighborhoodPersistencePort;

    public NeighborhoodUseCase(INeighborhoodPersistencePort neighborhoodPersistencePort) {
        this.neighborhoodPersistencePort = neighborhoodPersistencePort;
    }

    /**
     * @param neighborhood the neighborhood to be saved
     */
    @Override
    public void saveNeighborhood(Neighborhood neighborhood) {
        neighborhoodPersistencePort.saveNeighborhood(neighborhood);
    }

    /**
     * @param neighborhood the neighborhood to be updated
     */
    @Override
    public void updateNeighborhood(Neighborhood neighborhood) {
        neighborhoodPersistencePort.updateNeighborhood(neighborhood);
    }


    /**
     * @param neighborhoodName the name of the neighborhood to be deleted
     */
    @Override
    public void deleteNeighborhood(String neighborhoodName) {
        neighborhoodPersistencePort.deleteNeighborhood(neighborhoodName);
    }

    /**
     *
     * @param neighborhoodId
     * @return the neighborhood found
     */
    @Override
    public Neighborhood getNeighborhood(Long neighborhoodId) {
        return neighborhoodPersistencePort.getNeighborhood(neighborhoodId);
    }
    /**
     * @param neighborhoodName the name of the neighborhood to be found
     * @return the neighborhood found
     */
    @Override
    public Neighborhood findNeighborhoodByName(String neighborhoodName) {
        return neighborhoodPersistencePort.findByName(neighborhoodName);
    }

    /**
     * @return all the neighborhoods
     */
    @Override
    public List<Neighborhood> getAllNeighborhoods() {
        return neighborhoodPersistencePort.getAllNeighborhoods();
    }
}
