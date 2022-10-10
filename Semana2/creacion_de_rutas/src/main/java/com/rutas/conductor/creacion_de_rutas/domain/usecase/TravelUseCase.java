package com.rutas.conductor.creacion_de_rutas.domain.usecase;

import com.rutas.conductor.creacion_de_rutas.domain.api.ITravelServicePort;
import com.rutas.conductor.creacion_de_rutas.domain.exceptions.DateAndHourNotPresentException;
import com.rutas.conductor.creacion_de_rutas.domain.model.Travel;
import com.rutas.conductor.creacion_de_rutas.domain.spi.ITravelPersistencePort;

import java.util.List;

public class TravelUseCase implements ITravelServicePort {
    private final ITravelPersistencePort travelPersistencePort;

    public TravelUseCase(ITravelPersistencePort travelPersistencePort) {
        this.travelPersistencePort = travelPersistencePort;
    }

    /**
     * @param travelList List of datesRoute to be saved
     */
    @Override
    public void saveTravel(List<Travel> travelList) {
        if (travelList.size() == 0) {
            throw new DateAndHourNotPresentException();
        }
        for (Travel travel : travelList) {
            travelPersistencePort.saveTravel(travel);
        }
    }

    /**
     * @param travel travel to update
     */
    @Override
    public void updateTravel(Travel travel) {
        travelPersistencePort.updateTravel(travel);
    }


    /**
     * @param routeId the id of the route to delete all datesRoute
     */
    @Override
    public void deleteTravelsOfARoute(Long routeId) {
        travelPersistencePort.deleteTravelOfARoute(routeId);
    }

    /**
     * @param date
     */
    @Override
    public void deleteTravel(Long routeId,String date) {
        travelPersistencePort.deleteTravel(routeId, date);
    }

    /**
     * @param routeId the id of the route to get all datesRoute
     * @return  List of datesRoute of a route
     */
    @Override
    public List<Travel> findTravelByRoute(Long routeId) {
        return travelPersistencePort.findTravelByRoute(routeId);
    }

    /**
     * @return all datesRoute
     */
    @Override
    public List<Travel> getAllTravel() {
        return travelPersistencePort.getAllTravel();
    }
}
