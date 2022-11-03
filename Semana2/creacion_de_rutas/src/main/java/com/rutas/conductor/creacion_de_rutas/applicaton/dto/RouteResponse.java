package com.rutas.conductor.creacion_de_rutas.applicaton.dto;

import java.util.List;


public class RouteResponse {
    private String routeName;
    private NeighborhoodResponse origin;
    private NeighborhoodResponse destination;
    private List<RouteNeighborhoodDto> stops;
    private List<TravelDto> travelDates;
    private Integer quota;

    public RouteResponse(){}
    public RouteResponse(String routeName, NeighborhoodResponse origin, NeighborhoodResponse destination, List<RouteNeighborhoodDto> stops, List<TravelDto> travelDates, Integer quota) {
        this.routeName = routeName;
        this.origin = origin;
        this.destination = destination;
        this.stops = stops;
        this.travelDates = travelDates;
        this.quota = quota;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public NeighborhoodResponse getOrigin() {
        return origin;
    }

    public void setOrigin(NeighborhoodResponse origin) {
        this.origin = origin;
    }

    public NeighborhoodResponse getDestination() {
        return destination;
    }

    public void setDestination(NeighborhoodResponse destination) {
        this.destination = destination;
    }

    public List<RouteNeighborhoodDto> getStops() {
        return stops;
    }

    public void setStops(List<RouteNeighborhoodDto> stops) {
        this.stops = stops;
    }

    public List<TravelDto> getTravelDates() {
        return travelDates;
    }

    public void setTravelDates(List<TravelDto> travelDates) {
        this.travelDates = travelDates;
    }

    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }
}
