package com.rutas.conductor.creacion_de_rutas.domain.usecase;

import com.rutas.conductor.creacion_de_rutas.domain.api.IRouteServicePort;
import com.rutas.conductor.creacion_de_rutas.domain.exceptions.QuotaNotValidException;
import com.rutas.conductor.creacion_de_rutas.domain.model.Route;
import com.rutas.conductor.creacion_de_rutas.domain.spi.IRoutePersistencePort;

import java.util.List;

public class RouteUseCase implements IRouteServicePort {

    private final IRoutePersistencePort routePersistencePort;

    public RouteUseCase(IRoutePersistencePort routePersistencePort) {
        this.routePersistencePort = routePersistencePort;
    }

    /**
     * @param route RouteEntity to be saved
     * @return
     */
    @Override
    public Route saveRoute(Route route) {
        validationOfComplianceWithTheRequirementsForSaveRoute(route);
        routePersistencePort.saveRoute(route);
        return route;
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
     * @param routeName route name to delete
     */
    @Override
    public void deleteRoute(String routeName) {
        routePersistencePort.deleteRoute(routeName);
    }

    /**
     * @param routeName
     * @return
     */
    @Override
    public Route findRouteByName(String routeName) {
        return routePersistencePort.findRouteByName(routeName);
    }

    /**
     * @return List of all routes
     */
    @Override
    public List<Route> getAllRoutes() {
        return routePersistencePort.getAllRoutes();
    }
}

