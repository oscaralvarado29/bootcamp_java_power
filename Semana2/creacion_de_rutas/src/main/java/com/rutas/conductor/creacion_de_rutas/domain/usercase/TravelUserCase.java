package com.rutas.conductor.creacion_de_rutas.domain.usercase;

import com.rutas.conductor.creacion_de_rutas.domain.api.ITravelServicePort;
import com.rutas.conductor.creacion_de_rutas.domain.exceptions.DateAndHourNotPresentException;
import com.rutas.conductor.creacion_de_rutas.domain.model.Travel;
import com.rutas.conductor.creacion_de_rutas.domain.spi.ITravelPersistencePort;

import java.util.List;

public class TravelUserCase implements ITravelServicePort {
    private final ITravelPersistencePort travelPersistencePort;

    public TravelUserCase(ITravelPersistencePort travelPersistencePort) {
        this.travelPersistencePort = travelPersistencePort;
    }

    /**
     * @param travel the travel to be saved
     */
    @Override
    public void saveTravel(Travel travel) {
        if (travel.getTravelDates().size()==0){
            throw new DateAndHourNotPresentException();
        }
        travelPersistencePort.saveTravel(travel);
    }

    /**
     * @param travel the travel to be updated
     */
    @Override
    public void updateTravel(Travel travel) {
        travelPersistencePort.updateTravel(travel);
    }

    /**
     * @param travelId the id of the travel to be deleted
     */
    @Override
    public void deleteTravel(Long travelId) {
        travelPersistencePort.deleteTravel(travelId);
    }

    /**
     * @param travelId the id of the travel to be found
     * @return the travel found
     */
    @Override
    public Travel getTravel(Long travelId) {
        return travelPersistencePort.getTravel(travelId);
    }

    /**
     * @return all the travels
     */
    @Override
    public List<Travel> getAllTravels() {
        return travelPersistencePort.getAllTravels();
    }
}
