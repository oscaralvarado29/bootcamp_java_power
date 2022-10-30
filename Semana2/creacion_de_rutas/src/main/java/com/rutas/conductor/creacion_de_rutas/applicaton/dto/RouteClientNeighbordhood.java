package com.rutas.conductor.creacion_de_rutas.applicaton.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RouteClientNeighbordhood {

    private Long routeNeighborhoodId;
    private Long routeId;
    private String neighborhoodName;
    private String meetingPoint;
    private Integer position;
}
