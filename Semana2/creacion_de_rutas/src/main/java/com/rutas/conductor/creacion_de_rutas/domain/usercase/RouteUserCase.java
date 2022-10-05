package com.rutas.conductor.creacion_de_rutas.domain.usercase;

import com.rutas.conductor.creacion_de_rutas.domain.api.IRouteServicePort;
import com.rutas.conductor.creacion_de_rutas.domain.exceptions.QuotaNotValidException;
import com.rutas.conductor.creacion_de_rutas.domain.model.Route;
import com.rutas.conductor.creacion_de_rutas.domain.spi.IRoutePersistencePort;

import java.util.List;

public class RouteUserCase implements IRouteServicePort {

    private final IRoutePersistencePort routePersistencePort;

    public RouteUserCase(IRoutePersistencePort routePersistencePort) {
        this.routePersistencePort = routePersistencePort;
    }

    /**
     * @param route Route to be saved
     */
    @Override
    public void saveRoute(Route route) {
        validationOfComplianceWithTheRequirementsForSaveRoute(route);
        routePersistencePort.saveRoute(route);
    }

    private void validationOfComplianceWithTheRequirementsForSaveRoute(Route route) {

        if (route.getQuota() < 1 || route.getQuota() > 4) {
            throw new QuotaNotValidException();
        }

    }


    /**
     * @param route route to update
     */
    @Override
    public void updateRoute(Route route) {
        routePersistencePort.updateRoute(route);
    }

    /**
     * @param routeId routeId of route to delete
     */
    @Override
    public void deleteRoute(Long routeId) {
        routePersistencePort.deleteRoute(routeId);
    }

    /**
     * @param routeId route id to get route
     * @return Route with routeId
     */
    @Override
    public Route getRoute(Long routeId) {
        return routePersistencePort.getRoute(routeId);
    }

    /**
     * @return List of all routes
     */
    @Override
    public List<Route> getAllRoutes() {
        return routePersistencePort.getAllRoutes();
    }
}

