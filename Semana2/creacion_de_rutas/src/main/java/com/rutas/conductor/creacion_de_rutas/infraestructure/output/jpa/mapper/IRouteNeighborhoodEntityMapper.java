package com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.mapper;

import com.rutas.conductor.creacion_de_rutas.domain.model.RouteNeighborhood;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.entity.RouteNeighborhoodEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRouteNeighborhoodEntityMapper {

    RouteNeighborhoodEntity toRouteNeighborhoodEntity(RouteNeighborhood routeNeighborhood);
    RouteNeighborhood toRouteNeighborhood(RouteNeighborhoodEntity routeNeighborhoodEntity);
    List<RouteNeighborhood> toRouteNeighborhoodList(List<RouteNeighborhoodEntity> routeNeighborhoodEntityList);
    List<RouteNeighborhoodEntity> toRouteNeighborhoodEntityList(List<RouteNeighborhood> routeNeighborhoodList);
}
