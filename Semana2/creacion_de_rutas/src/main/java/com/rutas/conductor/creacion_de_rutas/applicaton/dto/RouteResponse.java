package com.rutas.conductor.creacion_de_rutas.applicaton.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RouteResponse {
    private String routeName;
    private NeighborhoodResponse origin;
    private NeighborhoodResponse destination;
    private List<RouteNeighborhoodDto> stops;
    private List<DatesRouteDto> travelDates;
    private Integer quota;
}
