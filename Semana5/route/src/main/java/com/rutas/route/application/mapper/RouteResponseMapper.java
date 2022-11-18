package com.rutas.route.application.mapper;

import com.rutas.route.application.dto.RouteResponse;
import com.rutas.route.domain.model.Neighborhood;
import com.rutas.route.domain.model.Route;
import com.rutas.route.domain.model.RouteNeighborhood;
import com.rutas.route.domain.model.Travel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        uses = {NeighborhoodResponseMapper.class, TravelDtoMapper.class,  RouteNeighborhoodDtoMapper.class})
public interface RouteResponseMapper{
    NeighborhoodResponseMapper INSTANCENEIGHBORHOOD = Mappers.getMapper(NeighborhoodResponseMapper.class);
    TravelDtoMapper INSTANCETRAVEL = Mappers.getMapper(TravelDtoMapper.class);
    RouteNeighborhoodDtoMapper INSTANCEROUTENEIGHBORHOOD = Mappers.getMapper(RouteNeighborhoodDtoMapper.class);

    default RouteResponse toRouteResponse(Route route, Neighborhood origin, Neighborhood destination, List<Neighborhood> neighborhoodList, List<RouteNeighborhood> stops, List<Travel> travelDates){

        RouteResponse routeResponse = new RouteResponse();
        routeResponse.setRouteName(route.getRouteName());
        routeResponse.setOrigin(INSTANCENEIGHBORHOOD.toNeighborhoodResponse(origin));
        routeResponse.setDestination(INSTANCENEIGHBORHOOD.toNeighborhoodResponse(destination));
        routeResponse.setStops(INSTANCEROUTENEIGHBORHOOD.toRouteNeighborhoodDtoList(stops,neighborhoodList));
        routeResponse.setTravelDates(INSTANCETRAVEL.toTravelDtoList(travelDates));
        routeResponse.setQuota(route.getQuota());
        return routeResponse;
    }
    default List<RouteResponse> toRouteResponseList(List<Route> routeList, List<Neighborhood> neighborhoodList, List<RouteNeighborhood>routeNeighborhoodList, List<Travel> travelList){
        return routeList.stream().map(route ->  {
            RouteResponse routeResponse = new RouteResponse();
            routeResponse.setRouteName(route.getRouteName());
            routeResponse.setOrigin(INSTANCENEIGHBORHOOD.toNeighborhoodResponse(neighborhoodList.stream().filter(neighborhood -> neighborhood.getNeighborhoodId().equals(route.getOriginNeighborhood())).findFirst().orElse(null)));
            routeResponse.setDestination(INSTANCENEIGHBORHOOD.toNeighborhoodResponse(neighborhoodList.stream().filter(neighborhood -> neighborhood.getNeighborhoodId().equals(route.getDestinationNeighborhood())).findFirst().orElse(null)));
            routeResponse.setStops(INSTANCEROUTENEIGHBORHOOD.toRouteNeighborhoodDtoList(routeNeighborhoodList.stream().filter(routeNeighborhood -> routeNeighborhood.getRouteId().equals(route.getRouteId())).collect(Collectors.toList()), neighborhoodList));
            routeResponse.setTravelDates(INSTANCETRAVEL.toTravelDtoList(travelList.stream().filter(travel -> travel.getRouteId().equals(route.getRouteId())).collect(Collectors.toList())));
            routeResponse.setQuota(route.getQuota());
            return routeResponse;
        }).collect(Collectors.toList());
    }
}

