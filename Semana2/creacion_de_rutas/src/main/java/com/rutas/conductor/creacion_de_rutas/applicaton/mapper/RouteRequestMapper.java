package com.rutas.conductor.creacion_de_rutas.applicaton.mapper;

import com.rutas.conductor.creacion_de_rutas.applicaton.dto.RouteRequest;
import com.rutas.conductor.creacion_de_rutas.domain.model.DatesRoute;
import com.rutas.conductor.creacion_de_rutas.domain.model.Route;
import com.rutas.conductor.creacion_de_rutas.domain.model.RouteNeighborhood;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RouteRequestMapper {

    @Mapping(target = "originNeighborhood",source = "origin.neighborhoodId")
    @Mapping(target = "destinationNeighborhood",source = "destination.neighborhoodId")
    Route toRoute(RouteRequest routeRequest);

    default List<RouteNeighborhood> toRouteNeighborhoodList(RouteRequest routeRequest){
        List<RouteNeighborhood> routeNeighborhoods = new ArrayList<>();
        routeNeighborhoods.add(routeRequest.getOrigin());
        routeNeighborhoods.addAll(routeRequest.getStops());
        routeNeighborhoods.add(routeRequest.getDestination());
        return routeNeighborhoods;
    }


    default List<DatesRoute> toDatesRouteList(RouteRequest routeRequest) {
        return routeRequest.getTravelDates();
    }
}
