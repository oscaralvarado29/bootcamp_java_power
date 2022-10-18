package com.rutas.conductor.creacion_de_rutas.domain.usecase;

import com.rutas.conductor.creacion_de_rutas.domain.api.IRouteNeighborhoodServicePort;
import com.rutas.conductor.creacion_de_rutas.domain.exceptions.RepeatedNeighborhoodsException;
import com.rutas.conductor.creacion_de_rutas.domain.model.RouteNeighborhood;
import com.rutas.conductor.creacion_de_rutas.domain.spi.IRouteNeighborhoodPersistencePort;

import java.util.List;
import java.util.ArrayList;

public class RouteNeighborhoodUseCase implements IRouteNeighborhoodServicePort {

    private final IRouteNeighborhoodPersistencePort routeNeighborhoodPersistencePort;

    public RouteNeighborhoodUseCase(IRouteNeighborhoodPersistencePort routeNeighborhoodPersistencePort) {
        this.routeNeighborhoodPersistencePort = routeNeighborhoodPersistencePort;
    }

    /**
     * @param routeNeighborhoodList routeNeighborhood list to be saved
     */
    @Override
    public void saveRouteNeighborhood(List<RouteNeighborhood> routeNeighborhoodList) {
        validationOfComplianceWithTheRequirementsForSaveRouteNeighborhood(routeNeighborhoodList);
        for (RouteNeighborhood routeNeighborhood : routeNeighborhoodList) {
            routeNeighborhoodPersistencePort.saveRouteNeighborhood(routeNeighborhood);
        }
    }

    private void validationOfComplianceWithTheRequirementsForSaveRouteNeighborhood(List<RouteNeighborhood>  routeNeighborhoodList) {

        List<Long> neighborhoodIdList = new ArrayList<>();
        for (RouteNeighborhood routeNeighborhood : routeNeighborhoodList) {
            if (!neighborhoodIdList.contains(routeNeighborhood.getNeighborhoodId())) {
                neighborhoodIdList.add(routeNeighborhood.getNeighborhoodId());
            }
        }
        if (neighborhoodIdList.size() != routeNeighborhoodList.size()) {
            throw new RepeatedNeighborhoodsException();
        }
    }

    /**
     * @param routeNeighborhood  routeNeighborhood to update
     */
    @Override
    public void updateRouteNeighborhood(RouteNeighborhood routeNeighborhood) {
        routeNeighborhoodPersistencePort.updateRouteNeighborhood(routeNeighborhood);
    }

    /**
     * @param routeId routeNeighborhoodId of routeNeighborhood to delete
     */
    @Override
    public void deleteRouteNeighborhoodByRoute(Long routeId) {
        routeNeighborhoodPersistencePort.deleteRouteNeighborhoodByRoute(routeId);
    }

    /**
     * @return all routeNeighborhoods
     */
    @Override
    public List<RouteNeighborhood> getAllRouteNeighborhoods() {
        return routeNeighborhoodPersistencePort.getAllRouteNeighborhoods();
    }

    /**
     * @param routeId routeId of routeNeighborhood to get
     * @return all routeNeighborhoods of a route
     */
    @Override
    public List<RouteNeighborhood> findRouteNeighborhoodByRoute(Long routeId) {
        return routeNeighborhoodPersistencePort.findRouteNeighborhoodByRoute(routeId);
    }
}
