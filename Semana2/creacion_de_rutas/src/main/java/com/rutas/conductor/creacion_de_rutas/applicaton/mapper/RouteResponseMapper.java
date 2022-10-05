package com.rutas.conductor.creacion_de_rutas.applicaton.mapper;

import com.rutas.conductor.creacion_de_rutas.applicaton.dto.RouteResponse;
import com.rutas.conductor.creacion_de_rutas.domain.model.DatesRoute;
import com.rutas.conductor.creacion_de_rutas.domain.model.Neighborhood;
import com.rutas.conductor.creacion_de_rutas.domain.model.Route;
import com.rutas.conductor.creacion_de_rutas.domain.model.RouteNeighborhood;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        uses = {NeighborhoodResponseMapper.class, DatesRouteDtoMapper.class,  RouteNeighborhoodDtoMapper.class})
public interface RouteResponseMapper{
    NeighborhoodResponseMapper INSTANCENEIGHBORHOOD = Mappers.getMapper(NeighborhoodResponseMapper.class);
    DatesRouteDtoMapper INSTANCEDATESROUTE = Mappers.getMapper(DatesRouteDtoMapper.class);
    RouteNeighborhoodDtoMapper INSTANCEROUTENEIGHBORHOOD = Mappers.getMapper(RouteNeighborhoodDtoMapper.class);

    default RouteResponse toRouteResponse(Route route, Neighborhood origin, Neighborhood destination, List<RouteNeighborhood> stops, List<DatesRoute> travelDates){

        RouteResponse routeResponse = new RouteResponse();
        routeResponse.setOrigin(INSTANCENEIGHBORHOOD.toNeighborhoodResponse(origin));
        routeResponse.setDestination(INSTANCENEIGHBORHOOD.toNeighborhoodResponse(destination));
        routeResponse.setStops(INSTANCEROUTENEIGHBORHOOD.toRouteNeighborhoodDtoList(stops));
        routeResponse.setTravelDates(INSTANCEDATESROUTE.toDateDtoList(travelDates));
        routeResponse.setQuota(route.getQuota());

        //route.getNeighborhoods().stream().map(NeighborhoodResponseMapper::toNeighborhoodResponse).collect(Collectors.toList()));
        return routeResponse;
    }
}
