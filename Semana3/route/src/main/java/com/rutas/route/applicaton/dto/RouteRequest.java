package com.rutas.route.applicaton.dto;

import com.rutas.route.domain.model.RouteNeighborhood;
import com.rutas.route.domain.model.Travel;
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
    private List<Travel> travelDates;
    private Integer quota;
    private String conductorEmail;
}

