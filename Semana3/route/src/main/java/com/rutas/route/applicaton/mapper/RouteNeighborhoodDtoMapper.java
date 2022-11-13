package com.rutas.route.applicaton.mapper;

import com.rutas.route.applicaton.dto.RouteNeighborhoodDto;
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
public interface RouteNeighborhoodDtoMapper {
    default RouteNeighborhoodDto toRouteNeighborhoodDto(RouteNeighborhood routeNeighborhood, List<Neighborhood> neighborhoods){
        RouteNeighborhoodDto routeNeighborhoodDto = new RouteNeighborhoodDto();
        Optional<Neighborhood> neighborhoodWithId = neighborhoods.stream().filter(neighborhood -> neighborhood.getNeighborhoodId().equals(routeNeighborhood.getNeighborhoodId())).findFirst();
        neighborhoodWithId.ifPresent(neighborhood -> routeNeighborhoodDto.setNeighborhoodName(neighborhood.getNeighborhoodName()));
        routeNeighborhoodDto.setMeetingPoint(routeNeighborhood.getMeetingPoint());
        routeNeighborhoodDto.setPosition(routeNeighborhood.getPosition());
        return routeNeighborhoodDto;
    }
    default List<RouteNeighborhoodDto> toRouteNeighborhoodDtoList(List<RouteNeighborhood> routeNeighborhoods, List<Neighborhood> neighborhoods){
        return routeNeighborhoods.stream().map(routeNeighborhood -> toRouteNeighborhoodDto(routeNeighborhood, neighborhoods)).collect(Collectors.toList());
    }
    RouteNeighborhood toRouteNeighborhood(RouteNeighborhoodDto routeNeighborhoodDto);
    List<RouteNeighborhood> toRouteNeighborhoodList(List<RouteNeighborhoodDto> routeNeighborhoodDtos);
}

