package com.rutas.conductor.creacion_de_rutas.applicaton.handler;

import com.rutas.conductor.creacion_de_rutas.applicaton.dto.RouteRequest;
import com.rutas.conductor.creacion_de_rutas.applicaton.dto.RouteResponse;
import com.rutas.conductor.creacion_de_rutas.applicaton.mapper.RouteRequestMapper;
import com.rutas.conductor.creacion_de_rutas.applicaton.mapper.RouteResponseMapper;
import com.rutas.conductor.creacion_de_rutas.domain.api.ITravelServicePort;
import com.rutas.conductor.creacion_de_rutas.domain.api.INeighborhoodServicePort;
import com.rutas.conductor.creacion_de_rutas.domain.api.IRouteNeighborhoodServicePort;
import com.rutas.conductor.creacion_de_rutas.domain.api.IRouteServicePort;
import com.rutas.conductor.creacion_de_rutas.domain.model.Travel;
import com.rutas.conductor.creacion_de_rutas.domain.model.Neighborhood;
import com.rutas.conductor.creacion_de_rutas.domain.model.Route;
import com.rutas.conductor.creacion_de_rutas.domain.model.RouteNeighborhood;
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
    private final IRouteNeighborhoodServicePort routeNeighborhoodServicePort;
    private final INeighborhoodServicePort neighborhoodServicePort;
    private final RouteRequestMapper routeRequestMapper;
    private final RouteResponseMapper routeResponseMapper;


    @Override
    public void saveRouteInDB(RouteRequest routeRequest) {
        routeServicePort.saveRoute(routeRequestMapper.toRoute(routeRequest));
        Route route = routeServicePort.findRouteByName(routeRequest.getRouteName());
        Long routeId = route.getRouteId();
        List<RouteNeighborhood> neighborhoodList = routeRequestMapper.toRouteNeighborhoodList(routeRequest);
        List<Travel> travelList = routeRequestMapper.toDatesRouteList(routeRequest);
        for (RouteNeighborhood routeNeighborhood : neighborhoodList) {
            routeNeighborhood.setRouteId(routeId);
            System.out.println("el id de la ruta es: " + routeId);
        }
        for (Travel travel : travelList) {
            travel.setRouteId(route.getRouteId());
            System.out.println("el id de la ruta es: " + route.getRouteId());
        }
        routeNeighborhoodServicePort.saveRouteNeighborhood(neighborhoodList);
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
        List<RouteNeighborhood> stops = routeNeighborhoodServicePort.findRouteNeighborhoodByRoute(route.getRouteId());
        List<Travel> travel = travelServicePort.findTravelByRoute(route.getRouteId());
        return routeResponseMapper.toRouteResponse(route, origin, destination, stops, travel);
    }

    @Override
    public void deleteRouteInDB(String routeName) {
        Route route = routeServicePort.findRouteByName(routeName);
        routeNeighborhoodServicePort.deleteRouteNeighborhoodByRoute(route.getRouteId());
        travelServicePort.deleteTravelsOfARoute(route.getRouteId());
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
            List<Travel> newTravels = routeRequestMapper.toDatesRouteList(routeRequest);
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
