package com.rutas.conductor.creacion_de_rutas.applicaton.dto;

import com.rutas.conductor.creacion_de_rutas.domain.model.Travel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RouteClientRequest {

    private String routeName;
    private String description;
    private RouteClientNeighbordhood origin;
    private RouteClientNeighbordhood destination;
    private List<RouteClientNeighbordhood> stops;
    private List<Travel> travelDates;
    private Integer quota;
    private String conductorEmail;
}
