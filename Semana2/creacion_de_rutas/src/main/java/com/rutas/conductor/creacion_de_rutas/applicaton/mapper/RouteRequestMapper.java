package com.rutas.conductor.creacion_de_rutas.applicaton.mapper;

import com.rutas.conductor.creacion_de_rutas.applicaton.dto.RouteRequest;
import com.rutas.conductor.creacion_de_rutas.domain.model.Travel;
import com.rutas.conductor.creacion_de_rutas.domain.model.Route;
import com.rutas.conductor.creacion_de_rutas.domain.model.RouteNeighborhood;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RouteRequestMapper {

    default Route toRoute(RouteRequest routeRequest){
        Route route = new Route();
        route.setRouteName(routeRequest.getRouteName());
        route.setDescription(routeRequest.getDescription());
        route.setQuota(routeRequest.getQuota());
        route.setConductorId(routeRequest.getConductorId());
        return route;
    }

    default List<RouteNeighborhood> toRouteNeighborhoodList(RouteRequest routeRequest){
        List<RouteNeighborhood> routeNeighborhoods = new ArrayList<>();
        RouteNeighborhood origin = routeRequest.getOrigin();
        origin.setPosition(1);
        routeNeighborhoods.add(origin);
        routeNeighborhoods.addAll(routeRequest.getStops());
        RouteNeighborhood destination = routeRequest.getDestination();
        destination.setPosition(routeRequest.getStops().size()+1);
        routeNeighborhoods.add(destination);
        System.out.println("los id de las paradas quedaron: ");
        for(RouteNeighborhood routeNeighborhood: routeNeighborhoods){
            System.out.println(routeNeighborhood.getNeighborhoodId());
        }
        return routeNeighborhoods;
    }


    default List<Travel> toDatesRouteList(RouteRequest routeRequest) {
        return routeRequest.getTravelDates();
    }
}
