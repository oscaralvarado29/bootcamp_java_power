package com.rutas.route.application.handler;

import com.rutas.route.application.dto.RouteRequest;
import com.rutas.route.application.dto.RouteRequestClient;
import com.rutas.route.application.dto.RouteResponse;
import com.rutas.route.application.mapper.RouteClientRequestMapper;
import com.rutas.route.application.mapper.RouteRequestMapper;
import com.rutas.route.application.mapper.RouteResponseMapper;
import com.rutas.route.domain.api.INeighborhoodServicePort;
import com.rutas.route.domain.api.IRouteNeighborhoodServicePort;
import com.rutas.route.domain.api.IRouteServicePort;
import com.rutas.route.domain.api.ITravelServicePort;
import com.rutas.route.domain.api.IUserServicePort;
import com.rutas.route.domain.model.Neighborhood;
import com.rutas.route.domain.model.Route;
import com.rutas.route.domain.model.RouteNeighborhood;
import com.rutas.route.domain.model.Travel;
import com.rutas.route.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RouteHandler implements IRouteHandler {
    private final IRouteServicePort routeServicePort;
    private final ITravelServicePort travelServicePort;
    private final IUserServicePort userServicePort;
    private final IRouteNeighborhoodServicePort routeNeighborhoodServicePort;
    private final INeighborhoodServicePort neighborhoodServicePort;
    private final RouteRequestMapper routeRequestMapper;
    private final RouteResponseMapper routeResponseMapper;
    private final RouteClientRequestMapper routeClientRequestMapper;


    @Override
    public void saveRouteInDB(RouteRequestClient routeRequestClient) {
        List<Neighborhood> neighborhoods = neighborhoodServicePort.getAllNeighborhoods();
        RouteRequest routeRequest = routeClientRequestMapper.toRouteRequest(routeRequestClient, neighborhoods);
        User conductor =  userServicePort.findUserByEmail(routeRequest.getConductorEmail());
        Route routeWithOutConductorId = routeRequestMapper.toRoute(routeRequest);
        routeWithOutConductorId.setConductorId(conductor.getUserId());
        routeServicePort.saveRoute(routeWithOutConductorId);
        Route route = routeServicePort.findRouteByName(routeRequest.getRouteName());
        Long routeId = route.getRouteId();
        List<RouteNeighborhood> routeNeighborhoodList = routeRequestMapper.toRouteNeighborhoodList(routeRequest);
        List<Travel> travelList = routeRequestMapper.toTravelList(routeRequest);
        for (RouteNeighborhood routeNeighborhood : routeNeighborhoodList) {

            routeNeighborhood.setRouteId(routeId);
        }
        for (Travel travel : travelList) {
            travel.setRouteId(route.getRouteId());
        }
        routeNeighborhoodServicePort.saveRouteNeighborhood(routeNeighborhoodList);
        travelServicePort.saveTravel(travelList);

    }

    @Override
    public List<RouteResponse> getAllRoutesFromDB() {
        return routeResponseMapper.toRouteResponseList(routeServicePort.getAllRoutes(),neighborhoodServicePort.getAllNeighborhoods(), routeNeighborhoodServicePort.getAllRouteNeighborhoods(), travelServicePort.getAllTravel());
    }

    @Override
    public RouteResponse getRouteFromDBByName(String routeName) {
        Route route = routeServicePort.findRouteByName(routeName);
        Neighborhood origin = neighborhoodServicePort.getNeighborhood(route.getOriginNeighborhood());
        Neighborhood destination = neighborhoodServicePort.getNeighborhood(route.getDestinationNeighborhood());
        List<Neighborhood> neighborhoods = neighborhoodServicePort.getAllNeighborhoods();
        List<RouteNeighborhood> stops = routeNeighborhoodServicePort.findRouteNeighborhoodByRoute(route.getRouteId());
        List<Travel> travel = travelServicePort.findTravelByRoute(route.getRouteId());
        return routeResponseMapper.toRouteResponse(route, origin, destination, neighborhoods, stops, travel);
    }

    @Override
    public void deleteRouteInDB(String routeName) {
        Route route = routeServicePort.findRouteByName(routeName);
        routeNeighborhoodServicePort.deleteRouteNeighborhoodByRoute(route.getRouteId());
        travelServicePort.deleteTravelsOfARoute(route.getRouteId());
        routeServicePort.deleteRoute(routeName);
    }

    @Override
    public void deleteTravelInDB(String routeName, String travelDate) {
        Route route = routeServicePort.findRouteByName(routeName);
        travelServicePort.deleteTravel(route.getRouteId(), travelDate);
    }


    @Override
    public void updateRouteInDB(RouteRequest routeRequest) {
        Route oldRoute = routeServicePort.findRouteByName(routeRequest.getRouteName());
        if (!routeRequest.getStops().isEmpty()) {
            List<RouteNeighborhood> newRouteNeighborhoods = routeRequestMapper.toRouteNeighborhoodList(routeRequest);
            for (RouteNeighborhood routeNeighborhood : newRouteNeighborhoods) {
                routeNeighborhood.setRouteId(oldRoute.getRouteId());
                routeNeighborhoodServicePort.updateRouteNeighborhood(routeNeighborhood);
            }
        }
        if (!routeRequest.getTravelDates().isEmpty()) {
            List<Travel> newTravels = routeRequestMapper.toTravelList(routeRequest);
            for (Travel travel : newTravels) {
                travel.setRouteId(oldRoute.getRouteId());
                travelServicePort.updateTravel(travel);
            }
        }
        Route newRoute = routeRequestMapper.toRoute(routeRequest);
        newRoute.setRouteId(oldRoute.getRouteId());
        routeServicePort.updateRoute(newRoute);
    }
}
