package com.rutas.route.domain.usecase;

import com.rutas.route.domain.api.IRouteNeighborhoodServicePort;
import com.rutas.route.domain.exception.RepeatedNeighborhoodsException;
import com.rutas.route.domain.model.RouteNeighborhood;
import com.rutas.route.domain.spi.IRouteNeighborhoodPersistencePort;

import java.util.ArrayList;
import java.util.List;

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

