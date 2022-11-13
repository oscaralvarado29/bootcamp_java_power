package com.rutas.route.infraestructure.output.jpa.mapper;

import com.rutas.route.domain.model.RouteNeighborhood;
import com.rutas.route.infraestructure.output.jpa.entity.RouteNeighborhoodEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RouteNeighborhoodEntityMapper {
    RouteNeighborhoodEntity toRouteNeighborhoodEntity(RouteNeighborhood routeNeighborhood);
    RouteNeighborhood toRouteNeighborhood(RouteNeighborhoodEntity routeNeighborhoodEntity);
    List<RouteNeighborhood> toRouteNeighborhoodList(List<RouteNeighborhoodEntity> routeNeighborhoodEntityList);
}
