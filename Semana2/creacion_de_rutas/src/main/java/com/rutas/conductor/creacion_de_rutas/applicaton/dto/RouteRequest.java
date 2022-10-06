package com.rutas.conductor.creacion_de_rutas.applicaton.dto;

import com.rutas.conductor.creacion_de_rutas.domain.model.DatesRoute;
import com.rutas.conductor.creacion_de_rutas.domain.model.RouteNeighborhood;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RouteRequest {
    private String routeName;
    private String description;
    private RouteNeighborhood origin;
    private RouteNeighborhood destination;
    private List<RouteNeighborhood> stops;
    private List<DatesRoute> travelDates;
    private Integer quota;
    private Long conductorId;
}
