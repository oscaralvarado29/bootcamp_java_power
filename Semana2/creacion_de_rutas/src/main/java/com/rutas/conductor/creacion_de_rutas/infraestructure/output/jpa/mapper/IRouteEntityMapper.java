package com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.mapper;

import com.rutas.conductor.creacion_de_rutas.domain.model.Route;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.entity.RouteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRouteEntityMapper {

    RouteEntity toRouteEntity(Route route);
    Route toRoute(RouteEntity routeEntity);
    List<Route> toRouteList(List<RouteEntity> routeEntityList);
    List<RouteEntity> toRouteEntityList(List<Route> routeList);
}
