package com.rutas.conductor.creacion_de_rutas.applicaton.mapper;

import com.rutas.conductor.creacion_de_rutas.applicaton.dto.RouteClientNeighbordhood;
import com.rutas.conductor.creacion_de_rutas.applicaton.dto.RouteClientRequest;
import com.rutas.conductor.creacion_de_rutas.applicaton.dto.RouteRequest;
import com.rutas.conductor.creacion_de_rutas.domain.model.Neighborhood;
import com.rutas.conductor.creacion_de_rutas.domain.model.RouteNeighborhood;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RouteClientRequestMapper {

    default RouteRequest toRouteRequest(RouteClientRequest routeClientRequest, List<Neighborhood> neighborhoods) {
        RouteRequest routeRequest = new RouteRequest();

        routeRequest.setRouteName(routeClientRequest.getRouteName());
        routeRequest.setDescription(routeClientRequest.getDescription());
        routeRequest.setOrigin(toRouteNeighborhood(routeClientRequest.getOrigin(), neighborhoods));
        routeRequest.setDestination(toRouteNeighborhood(routeClientRequest.getDestination(), neighborhoods));
        routeRequest.setTravelDates(routeClientRequest.getTravelDates());
        routeRequest.setQuota(routeClientRequest.getQuota());
        routeRequest.setConductorEmail(routeClientRequest.getConductorEmail());
        return routeRequest;
    }

    default RouteNeighborhood toRouteNeighborhood(RouteClientNeighbordhood routeClientNeighbordhood, List<Neighborhood> neighborhoods) {
        RouteNeighborhood routeNeighborhood = new RouteNeighborhood(
                routeClientNeighbordhood.getRouteNeighborhoodId(),
                routeClientNeighbordhood.getRouteId(),
                neighborhoods.stream().filter(neighborhood -> neighborhood.getNeighborhoodName().equals(routeClientNeighbordhood.getNeighborhoodName())).findFirst().get().getNeighborhoodId(),
                routeClientNeighbordhood.getMeetingPoint(),
                routeClientNeighbordhood.getPosition()
        );
        return routeNeighborhood;
    }
}
