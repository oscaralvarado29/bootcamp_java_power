package com.rutas.conductor.creacion_de_rutas.applicaton.handler;

import com.rutas.conductor.creacion_de_rutas.applicaton.dto.RouteRequest;
import com.rutas.conductor.creacion_de_rutas.applicaton.dto.RouteResponse;
import com.rutas.conductor.creacion_de_rutas.applicaton.mapper.DatesRouteDtoMapper;
import com.rutas.conductor.creacion_de_rutas.applicaton.mapper.RouteNeighborhoodDtoMapper;
import com.rutas.conductor.creacion_de_rutas.applicaton.mapper.RouteRequestMapper;
import com.rutas.conductor.creacion_de_rutas.applicaton.mapper.RouteResponseMapper;
import com.rutas.conductor.creacion_de_rutas.domain.api.IDatesRouteServicePort;
import com.rutas.conductor.creacion_de_rutas.domain.api.INeighborhoodServicePort;
import com.rutas.conductor.creacion_de_rutas.domain.api.IRouteNeighborhoodServicePort;
import com.rutas.conductor.creacion_de_rutas.domain.api.IRouteServicePort;
import com.rutas.conductor.creacion_de_rutas.domain.model.DatesRoute;
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
    private final IDatesRouteServicePort datesRouteServicePort;
    private final IRouteNeighborhoodServicePort routeNeighborhoodServicePort;
    private final INeighborhoodServicePort neighborhoodServicePort;
    private final RouteRequestMapper routeRequestMapper;
    private final RouteResponseMapper routeResponseMapper;
    private final RouteNeighborhoodDtoMapper routeNeighborhoodDtoMapper;
    private final DatesRouteDtoMapper datesRouteDtoMapper;
    @Override
    public void saveRouteInDB(RouteRequest routeRequest) {
        Route route = routeServicePort.saveRoute(routeRequestMapper.toRoute(routeRequest));
        List<RouteNeighborhood> neighborhoodList = routeRequestMapper.toRouteNeighborhoodList(routeRequest);
        List<DatesRoute> datesRouteList = routeRequestMapper.toDatesRouteList(routeRequest);
        for (RouteNeighborhood routeNeighborhood : neighborhoodList) {
            routeNeighborhood.setRouteId(route.getRouteId());
            routeNeighborhoodServicePort.saveRouteNeighborhood(routeNeighborhood);
        }
        for (DatesRoute dateRoute : datesRouteList) {
            dateRoute.setRouteId(route.getRouteId());;
        }
        datesRouteServicePort.saveDatesRoute(datesRouteList);
    }

    @Override
    public List<RouteResponse> getAllRoutesFromDB() {
        return routeResponseMapper.toRouteResponseList(routeServicePort.getAllRoutes(),neighborhoodServicePort.getAllNeighborhoods(), routeNeighborhoodServicePort.getAllRouteNeighborhoods(), datesRouteServicePort.getAllDatesRoute());
    }

    @Override
    public RouteResponse getRouteFromDB(Long id) {
        Route route = routeServicePort.getRoute(id);
        Neighborhood origin = neighborhoodServicePort.getNeighborhood(route.getOriginNeighborhood());
        Neighborhood destination = neighborhoodServicePort.getNeighborhood(route.getDestinationNeighborhood());
        List<RouteNeighborhood> stops = routeNeighborhoodServicePort.findRouteNeighborhoodByRoute(id);
        List<DatesRoute> datesRoute = datesRouteServicePort.findDatesRouteByRoute(id);
        return routeResponseMapper.toRouteResponse(route, origin, destination, stops, datesRoute);
    }

    @Override
    public void deleteRouteInDB(String routeName) {
        Route route = routeServicePort.findRouteByName(routeName);
        routeNeighborhoodServicePort.deleteRouteNeighborhoodByRoute(route.getRouteId());
        datesRouteServicePort.deleteDatesRouteOfARoute(route.getRouteId());
    }


    @Override
    public void updateRouteInDB(RouteRequest routeRequest) {
        Route oldRoute = routeServicePort.findRouteByName(routeRequest.getRouteName());
        List<RouteNeighborhood> newRouteNeighborhoods = routeRequestMapper.toRouteNeighborhoodList(routeRequest);
        List<DatesRoute> newDatesRoute = routeRequestMapper.toDatesRouteList(routeRequest);
        Route newRoute = routeRequestMapper.toRoute(routeRequest);

        for (RouteNeighborhood routeNeighborhood : newRouteNeighborhoods) {
            routeNeighborhood.setRouteId(oldRoute.getRouteId());
            routeNeighborhoodServicePort.updateRouteNeighborhood(routeNeighborhood);
        }
        for (DatesRoute dateRoute : newDatesRoute) {
            dateRoute.setRouteId(oldRoute.getRouteId());;
            datesRouteServicePort.updateDatesRoute(dateRoute);
        }
        newRoute.setRouteId(oldRoute.getRouteId());
        routeServicePort.updateRoute(newRoute);
    }
}
