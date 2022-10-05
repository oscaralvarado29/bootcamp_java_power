package com.rutas.conductor.creacion_de_rutas.applicaton.mapper;

import com.rutas.conductor.creacion_de_rutas.applicaton.dto.RouteNeighborhoodDto;
import com.rutas.conductor.creacion_de_rutas.domain.model.RouteNeighborhood;

import java.util.List;

public interface RouteNeighborhoodDtoMapper {
    RouteNeighborhoodDto toRouteNeighborhoodDto(RouteNeighborhood routeNeighborhood);
    List<RouteNeighborhoodDto> toRouteNeighborhoodDtoList(List<RouteNeighborhood> routeNeighborhoods);
}
