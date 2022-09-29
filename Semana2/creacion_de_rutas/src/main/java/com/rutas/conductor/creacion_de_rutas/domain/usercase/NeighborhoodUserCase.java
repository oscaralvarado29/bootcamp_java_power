package com.rutas.conductor.creacion_de_rutas.domain.usercase;

import com.rutas.conductor.creacion_de_rutas.domain.api.INeighborhoodServicePort;
import com.rutas.conductor.creacion_de_rutas.domain.exceptions.NeighborhoodAlreadyExistsException;
import com.rutas.conductor.creacion_de_rutas.domain.exceptions.NeighborhoodNameNotPresentException;
import com.rutas.conductor.creacion_de_rutas.domain.exceptions.NeighborhoodNotFoundException;
import com.rutas.conductor.creacion_de_rutas.domain.model.Neighborhood;
import com.rutas.conductor.creacion_de_rutas.domain.spi.INeighborhoodPersistencePort;

import java.util.List;
import java.util.Optional;

public class NeighborhoodUserCase implements INeighborhoodServicePort {
    private final INeighborhoodPersistencePort neighborhoodPersistencePort;

    public NeighborhoodUserCase(INeighborhoodPersistencePort neighborhoodPersistencePort) {
        this.neighborhoodPersistencePort = neighborhoodPersistencePort;
    }

    /**
     * @param neighborhood the neighborhood to be saved
     */
    @Override
    public void saveNeighborhood(Neighborhood neighborhood) {

        if (neighborhood.getNeighborhoodName() != null) {
            Optional<Neighborhood> neighborhoodDB = Optional.ofNullable(neighborhoodPersistencePort.findNeighborhoodByName(neighborhood.getNeighborhoodName()));
            if (neighborhoodDB.isPresent()) {
                throw new NeighborhoodAlreadyExistsException();
            }
            neighborhoodPersistencePort.saveNeighborhood(neighborhood);
        } else {
            throw new NeighborhoodNameNotPresentException();
        }
    }

    /**
     * @param neighborhood the neighborhood to be updated
     */
    @Override
    public void updateNeighborhood(Neighborhood neighborhood) {
        Neighborhood neighborhoodToUpdate = validationOfComplianceWithTheRequirementsToBeUpdate(neighborhood);
        neighborhoodPersistencePort.updateNeighborhood(neighborhoodToUpdate);
    }

    private Neighborhood validationOfComplianceWithTheRequirementsToBeUpdate(Neighborhood neighborhood) {
        if (neighborhood.getNeighborhoodName() != null) {
            Optional<Neighborhood> neighborhoodDB = Optional.ofNullable(neighborhoodPersistencePort.findNeighborhoodByName(neighborhood.getNeighborhoodName()));
            if (neighborhoodDB.isPresent()) {
                if (neighborhood.getNeighborhoodName() != null) {
                    neighborhoodDB.get().setNeighborhoodName(neighborhood.getNeighborhoodName());
                }
                if (neighborhood.getNeighborhoodDescription() != null) {
                    neighborhoodDB.get().setNeighborhoodDescription(neighborhood.getNeighborhoodDescription());
                }
                return neighborhoodDB.get();
            }else {
                throw new NeighborhoodNotFoundException();
            }
        } else {
            throw new NeighborhoodNameNotPresentException();
        }
    }
    /**
     * @param neighborhoodName the name of the neighborhood to be deleted
     */
    @Override
    public void deleteNeighborhood(String neighborhoodName) {
        Optional<Neighborhood> neighborhoodDB = Optional.ofNullable(neighborhoodPersistencePort.findNeighborhoodByName(neighborhoodName));
        if (neighborhoodDB.isPresent()) {
            neighborhoodPersistencePort.deleteNeighborhood(neighborhoodName);
        } else {
            throw new NeighborhoodNotFoundException();
        }
    }

    /**
     * @param neighborhoodId the id of the neighborhood to be found
     * @return the neighborhood found
     */
    @Override
    public Neighborhood getNeighborhood(Long neighborhoodId) {
        return neighborhoodPersistencePort.getNeighborhood(neighborhoodId);
    }

    /**
     * @return all the neighborhoods
     */
    @Override
    public List<Neighborhood> getAllNeighborhoods() {
        return neighborhoodPersistencePort.getAllNeighborhoods();
    }
}
