package com.rutas.route.applicaton.mapper;

import com.rutas.route.applicaton.dto.RouteNeighborhoodDto;
import com.rutas.route.applicaton.dto.RouteRequest;
import com.rutas.route.applicaton.dto.RouteRequestClient;
import com.rutas.route.domain.model.Neighborhood;
import com.rutas.route.domain.model.RouteNeighborhood;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RouteClientRequestMapper {

    default RouteRequest toRouteRequest(RouteRequestClient routeRequestClient, List<Neighborhood> neighborhoods) {
        RouteRequest routeRequest = new RouteRequest();

        routeRequest.setRouteName(routeRequestClient.getRouteName());
        routeRequest.setDescription(routeRequestClient.getDescription());
        routeRequest.setOrigin(toRouteNeighborhood(routeRequestClient.getOrigin(), neighborhoods));
        routeRequest.setDestination(toRouteNeighborhood(routeRequestClient.getDestination(), neighborhoods));
        routeRequest.setStops(toRouteNeighborhoodList(routeRequestClient.getStops(), neighborhoods));
        routeRequest.setTravelDates(routeRequestClient.getTravelDates());
        routeRequest.setQuota(routeRequestClient.getQuota());
        routeRequest.setConductorEmail(routeRequestClient.getConductorEmail());
        return routeRequest;
    }

    default RouteNeighborhood toRouteNeighborhood(RouteNeighborhoodDto routeNeighborhoodDto, List<Neighborhood> neighborhoods) {
        RouteNeighborhood routeNeighborhood = new RouteNeighborhood();
        Optional<Neighborhood> neighborhoodWithId = neighborhoods.stream().filter(neighborhood -> neighborhood.getNeighborhoodName().equals(routeNeighborhoodDto.getNeighborhoodName())).findFirst();
        neighborhoodWithId.ifPresent(neighborhood -> routeNeighborhood.setNeighborhoodId(neighborhood.getNeighborhoodId()));
        routeNeighborhood.setMeetingPoint(routeNeighborhoodDto.getMeetingPoint());
        routeNeighborhood.setPosition(routeNeighborhoodDto.getPosition());
        System.out.println("El id de la parada es: " + neighborhoodWithId.get().getNeighborhoodName());
        return routeNeighborhood;
    }

    default List<RouteNeighborhood> toRouteNeighborhoodList(List<RouteNeighborhoodDto> routeNeighborhoodDtos, List<Neighborhood> neighborhoods) {
        return routeNeighborhoodDtos.stream().map(routeNeighborhoodDto -> toRouteNeighborhood(routeNeighborhoodDto, neighborhoods)).collect(Collectors.toList());
    }
}

