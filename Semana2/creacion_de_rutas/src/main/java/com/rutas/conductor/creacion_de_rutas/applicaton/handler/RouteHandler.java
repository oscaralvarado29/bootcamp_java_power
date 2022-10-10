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
public class RouteHandler implements IRouteHandler {
    private final IRouteServicePort routeServicePort;
    private final ITravelServicePort travelServicePort;
    private final IRouteNeighborhoodServicePort routeNeighborhoodServicePort;
    private final INeighborhoodServicePort neighborhoodServicePort;
    private final RouteRequestMapper routeRequestMapper;
    private final RouteResponseMapper routeResponseMapper;

    public RouteHandler(RouteRequestMapper routeRequestMapper, IRouteServicePort routeServicePort, ITravelServicePort travelServicePort, IRouteNeighborhoodServicePort routeNeighborhoodServicePort, INeighborhoodServicePort neighborhoodServicePort,  RouteResponseMapper routeResponseMapper) {
        this.routeServicePort = routeServicePort;
        this.travelServicePort = travelServicePort;
        this.routeNeighborhoodServicePort = routeNeighborhoodServicePort;
        this.neighborhoodServicePort = neighborhoodServicePort;
        this.routeRequestMapper = routeRequestMapper;
        this.routeResponseMapper = routeResponseMapper;
    }

    @Override
    public void saveRouteInDB(RouteRequest routeRequest) {
        Route route = routeServicePort.saveRoute(routeRequestMapper.toRoute(routeRequest));
        List<RouteNeighborhood> neighborhoodList = routeRequestMapper.toRouteNeighborhoodList(routeRequest);
        List<Travel> travelList = routeRequestMapper.toDatesRouteList(routeRequest);
        for (RouteNeighborhood routeNeighborhood : neighborhoodList) {
            routeNeighborhood.setRouteId(route.getRouteId());
            routeNeighborhoodServicePort.saveRouteNeighborhood(routeNeighborhood);
        }
        for (Travel travel : travelList) {
            travel.setRouteId(route.getRouteId());
        }
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
        List<RouteNeighborhood> newRouteNeighborhoods = routeRequestMapper.toRouteNeighborhoodList(routeRequest);
        List<Travel> newTravel = routeRequestMapper.toDatesRouteList(routeRequest);
        Route newRoute = routeRequestMapper.toRoute(routeRequest);

        for (RouteNeighborhood routeNeighborhood : newRouteNeighborhoods) {
            routeNeighborhood.setRouteId(oldRoute.getRouteId());
            routeNeighborhoodServicePort.updateRouteNeighborhood(routeNeighborhood);
        }
        for (Travel dateRoute : newTravel) {
            dateRoute.setRouteId(oldRoute.getRouteId());
            travelServicePort.updateTravel(dateRoute);
        }
        newRoute.setRouteId(oldRoute.getRouteId());
        routeServicePort.updateRoute(newRoute);
    }
}
