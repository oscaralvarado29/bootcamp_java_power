package com.rutas.conductor.creacion_de_rutas.domain.usercase;

import com.rutas.conductor.creacion_de_rutas.domain.api.IRouteNeighborhoodServicePort;
import com.rutas.conductor.creacion_de_rutas.domain.model.RouteNeighborhood;
import com.rutas.conductor.creacion_de_rutas.domain.spi.IRouteNeighborhoodPersistencePort;

import java.util.List;

public class RouteNeighborhoodUserCase implements IRouteNeighborhoodServicePort {

    private final IRouteNeighborhoodPersistencePort routeNeighborhoodPersistencePort;

    public RouteNeighborhoodUserCase(IRouteNeighborhoodPersistencePort routeNeighborhoodPersistencePort) {
        this.routeNeighborhoodPersistencePort = routeNeighborhoodPersistencePort;
    }

    /**
     * @param routeNeighborhood routeNeighborhood to be saved
     */
    @Override
    public void saveRouteNeighborhood(RouteNeighborhood routeNeighborhood) {
        routeNeighborhoodPersistencePort.saveRouteNeighborhood(routeNeighborhood);
    }

    /**
     * @param routeNeighborhood  routeNeighborhood to update
     */
    @Override
    public void updateRouteNeighborhood(RouteNeighborhood routeNeighborhood) {
        routeNeighborhoodPersistencePort.updateRouteNeighborhood(routeNeighborhood);
    }

    /**
     * @param routeNeighborhoodId routeNeighborhoodId of routeNeighborhood to delete
     */
    @Override
    public void deleteRouteNeighborhood(Long routeNeighborhoodId) {
        routeNeighborhoodPersistencePort.deleteRouteNeighborhood(routeNeighborhoodId);
    }

    /**
     * @param routeNeighborhoodId routeNeighborhoodId of routeNeighborhood to get
     * @return routeNeighborhood with routeNeighborhoodId
     */
    @Override
    public RouteNeighborhood getRouteNeighborhood(Long routeNeighborhoodId) {
        return routeNeighborhoodPersistencePort.getRouteNeighborhood(routeNeighborhoodId);
    }

    /**
     * @return all routeNeighborhoods
     */
    @Override
    public List<RouteNeighborhood> getAllRouteNeighborhoods() {
        return routeNeighborhoodPersistencePort.getAllRouteNeighborhoods();
    }
}
