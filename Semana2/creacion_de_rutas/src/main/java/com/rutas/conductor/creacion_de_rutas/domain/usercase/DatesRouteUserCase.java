package com.rutas.conductor.creacion_de_rutas.domain.usercase;

import com.rutas.conductor.creacion_de_rutas.domain.api.IDatesRouteServicePort;
import com.rutas.conductor.creacion_de_rutas.domain.exceptions.DateAndHourNotPresentException;
import com.rutas.conductor.creacion_de_rutas.domain.model.DatesRoute;
import com.rutas.conductor.creacion_de_rutas.domain.spi.IDatesRoutePersistencePort;

import java.util.List;

public class DatesRouteUserCase implements IDatesRouteServicePort {
    private final IDatesRoutePersistencePort datesRoutePersistencePort;

    public DatesRouteUserCase(IDatesRoutePersistencePort datesRoutePersistencePort) {
        this.datesRoutePersistencePort = datesRoutePersistencePort;
    }

    /**
     * @param dateRoute List of datesRoute to be saved
     */
    @Override
    public void saveDatesRoute(List<DatesRoute> dateRoute) {
        if (dateRoute.size() == 0) {
            throw new DateAndHourNotPresentException();
        }
        for (DatesRoute datesRoute : dateRoute) {
            datesRoutePersistencePort.saveDatesRoute(datesRoute);
        }
    }

    /**
     * @param dateRoute dateRoute to update
     */
    @Override
    public void updateDatesRoute(DatesRoute dateRoute) {
        datesRoutePersistencePort.updateDatesRoute(dateRoute);
    }


    /**
     * @param routeId the id of the route to delete all datesRoute
     */
    @Override
    public void deleteDatesRouteOfARoute(Long routeId) {
        datesRoutePersistencePort.deleteDatesRouteOfARoute(routeId);
    }

    /**
     * @param dateRouteId the id of the dateRoute to get
     * @return DatesRoute that belong to the route with the id routeId
     */
    @Override
    public DatesRoute getDateRoute(Long dateRouteId) {
        return datesRoutePersistencePort.getDateRoute(dateRouteId);
    }

    /**
     * @param routeId the id of the route to get all datesRoute
     * @return  List of datesRoute of a route
     */
    @Override
    public List<DatesRoute> findDatesRouteByRoute(Long routeId) {
        return datesRoutePersistencePort.findDatesRouteByRoute(routeId);
    }

    /**
     * @return all datesRoute
     */
    @Override
    public List<DatesRoute> getAllDatesRoute() {
        return datesRoutePersistencePort.getAllDatesRoute();
    }
}
