package com.rutas.route.applicaton.dto;

import com.rutas.route.domain.model.Travel;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class RouteRequestClient {

    private String routeName;
    private String description;
    private RouteNeighborhoodDto origin;
    private RouteNeighborhoodDto destination;
    private List<RouteNeighborhoodDto> stops;
    private List<Travel> travelDates;
    private Integer quota;
    private String conductorEmail;
}
