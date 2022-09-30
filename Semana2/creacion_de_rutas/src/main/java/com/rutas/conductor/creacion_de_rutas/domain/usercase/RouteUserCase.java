package com.rutas.conductor.creacion_de_rutas.domain.usercase;

import com.rutas.conductor.creacion_de_rutas.domain.api.IRouteServicePort;
import com.rutas.conductor.creacion_de_rutas.domain.exceptions.DestinationIsNotTheLastStopException;
import com.rutas.conductor.creacion_de_rutas.domain.exceptions.OriginIsNotTheFirstStopException;
import com.rutas.conductor.creacion_de_rutas.domain.model.Route;
import com.rutas.conductor.creacion_de_rutas.domain.spi.IRoutePersistencePort;

import java.util.List;
import java.util.Optional;

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
        int numberStops = route.getStops().size();

        if (!route.getOrigin().equals(route.getStops().get(0)) ) {
            throw new OriginIsNotTheFirstStopException();
        }
        if (route.getDestination().equals(route.getStops().get(numberStops - 1))) {
            throw new DestinationIsNotTheLastStopException();
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

