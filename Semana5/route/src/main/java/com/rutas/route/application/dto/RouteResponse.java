package com.rutas.route.application.dto;

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
    private List<TravelDto> travelDates;
    private Integer quota;
}
