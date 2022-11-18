package com.rutas.route.infraestructure.output.jpa.mapper;

import com.rutas.route.domain.model.Route;
import com.rutas.route.infraestructure.output.jpa.entity.RouteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RouteEntityMapper {
    RouteEntity toRouteEntity(Route route);
    Route toRoute(RouteEntity routeEntity);
    List<Route> toRouteList(List<RouteEntity> routeEntityList);
}
