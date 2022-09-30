package com.rutas.conductor.creacion_de_rutas.domain.usercase;

import com.rutas.conductor.creacion_de_rutas.domain.api.IRouteServicePort;
import com.rutas.conductor.creacion_de_rutas.domain.exceptions.*;
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
        Optional<Route> routeDB = Optional.ofNullable(routePersistencePort.getRoute(route.getRouteId()));
        int numberStops = route.getStops().size();

        if (routeDB.isPresent()) {
            throw new RouteAlreadyExistsException();
        }
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
        Route routeToUpdate = validationOfComplianceWithTheRequirementsForUpdateRoute(route);
        routePersistencePort.updateRoute(routeToUpdate);
    }

    private Route validationOfComplianceWithTheRequirementsForUpdateRoute(Route route) {
        if (route.getRouteId() != null ) {
            Optional<Route> routeDB = Optional.ofNullable(routePersistencePort.getRoute(route.getRouteId()));
            if (routeDB.isPresent()) {
                if (route.getDescription() != null) {
                    routeDB.get().setDescription(route.getDescription());
                }
                if (route.getOrigin()!= null) {
                    List<String> stops = routeDB.get().getStops();
                    stops.set(0, route.getOrigin());
                    routeDB.get().setOrigin(route.getOrigin());
                    routeDB.get().setStops(stops);
                }
                if (route.getDestination() != null) {
                    List<String> stops = routeDB.get().getStops();
                    stops.set(stops.size() - 1, route.getDestination());
                    routeDB.get().setDestination(route.getDestination());
                    routeDB.get().setStops(stops);
                }
                if (route.getStops() != null) {
                    routeDB.get().setOrigin(route.getStops().get(0));
                    routeDB.get().setDestination(route.getStops().get(route.getStops().size() - 1));
                    routeDB.get().setStops(route.getStops());
                }
                if (route.getQuota() != null) {
                    routeDB.get().setQuota(route.getQuota());
                }
                if (route.getConductorId() != null) {
                    routeDB.get().setConductorId(route.getConductorId());
                }
                return routeDB.get();
            } else{
                throw new RouteNotFoudException();
            }
        } else{
            throw new RouteIdNotProvidedException();
        }


    }

    /**
     * @param routeId routeId of route to delete
     */
    @Override
    public void deleteRoute(Long routeId) {
        Optional<Route> routeDB = Optional.ofNullable(routePersistencePort.getRoute(routeId));
        if (routeDB.isEmpty()) {
            throw new RouteNotFoudException();
        }
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

