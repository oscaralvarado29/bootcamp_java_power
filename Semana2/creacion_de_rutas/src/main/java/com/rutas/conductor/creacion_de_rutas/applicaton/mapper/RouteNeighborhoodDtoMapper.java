package com.rutas.conductor.creacion_de_rutas.applicaton.mapper;

import com.rutas.conductor.creacion_de_rutas.applicaton.dto.RouteNeighborhoodDto;
import com.rutas.conductor.creacion_de_rutas.domain.model.RouteNeighborhood;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RouteNeighborhoodDtoMapper {
    RouteNeighborhoodDto toRouteNeighborhoodDto(RouteNeighborhood routeNeighborhood);
    List<RouteNeighborhoodDto> toRouteNeighborhoodDtoList(List<RouteNeighborhood> routeNeighborhoods);

}
