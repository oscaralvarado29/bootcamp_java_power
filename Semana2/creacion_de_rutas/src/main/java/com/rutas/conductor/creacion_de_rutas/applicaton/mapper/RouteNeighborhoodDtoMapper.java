package com.rutas.conductor.creacion_de_rutas.applicaton.mapper;

import com.rutas.conductor.creacion_de_rutas.applicaton.dto.RouteNeighborhoodDto;
import com.rutas.conductor.creacion_de_rutas.domain.model.Neighborhood;
import com.rutas.conductor.creacion_de_rutas.domain.model.RouteNeighborhood;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RouteNeighborhoodDtoMapper {
    default RouteNeighborhoodDto toRouteNeighborhoodDto(RouteNeighborhood routeNeighborhood, List<Neighborhood> neighborhoods){
        System.out.println("id de barrio: " + routeNeighborhood.getNeighborhoodId());
        RouteNeighborhoodDto routeNeighborhoodDto = new RouteNeighborhoodDto();
        Optional<Neighborhood> neighborhoodWithId = neighborhoods.stream().filter(neighborhood -> neighborhood.getNeighborhoodId().equals(routeNeighborhood.getNeighborhoodId())).findFirst();
        System.out.println("neighborhoodWithId: " + neighborhoodWithId);
        if (neighborhoodWithId.isPresent()) {
            routeNeighborhoodDto.setNeighborhoodName(neighborhoodWithId.get().getNeighborhoodName());
        }
        routeNeighborhoodDto.setMeetingPoint(routeNeighborhood.getMeetingPoint());
        routeNeighborhoodDto.setPosition(routeNeighborhood.getPosition());
        return routeNeighborhoodDto;
    }
    default List<RouteNeighborhoodDto> toRouteNeighborhoodDtoList(List<RouteNeighborhood> routeNeighborhoods, List<Neighborhood> neighborhoods){
        System.out.println("Entra aqui x2: " );
        return routeNeighborhoods.stream().map(routeNeighborhood -> toRouteNeighborhoodDto(routeNeighborhood, neighborhoods)).collect(Collectors.toList());
    }
    RouteNeighborhood toRouteNeighborhood(RouteNeighborhoodDto routeNeighborhoodDto);
    List<RouteNeighborhood> toRouteNeighborhoodList(List<RouteNeighborhoodDto> routeNeighborhoodDtos);
}
