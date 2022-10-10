package com.rutas.conductor.creacion_de_rutas.applicaton.dto;

import com.rutas.conductor.creacion_de_rutas.domain.model.Travel;
import com.rutas.conductor.creacion_de_rutas.domain.model.RouteNeighborhood;

import java.util.List;

public class RouteRequest {
    private String routeName;
    private String description;
    private RouteNeighborhood origin;
    private RouteNeighborhood destination;
    private List<RouteNeighborhood> stops;
    private List<Travel> travelDates;
    private Integer quota;
    private Long conductorId;

    public RouteRequest(String routeName, String description, RouteNeighborhood origin, RouteNeighborhood destination, List<RouteNeighborhood> stops, List<Travel> travelDates, Integer quota, Long conductorId) {
        this.routeName = routeName;
        this.description = description;
        this.origin = origin;
        this.destination = destination;
        this.stops = stops;
        this.travelDates = travelDates;
        this.quota = quota;
        this.conductorId = conductorId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RouteNeighborhood getOrigin() {
        return origin;
    }

    public void setOrigin(RouteNeighborhood origin) {
        this.origin = origin;
    }

    public RouteNeighborhood getDestination() {
        return destination;
    }

    public void setDestination(RouteNeighborhood destination) {
        this.destination = destination;
    }

    public List<RouteNeighborhood> getStops() {
        return stops;
    }

    public void setStops(List<RouteNeighborhood> stops) {
        this.stops = stops;
    }

    public List<Travel> getTravelDates() {
        return travelDates;
    }

    public void setTravelDates(List<Travel> travelDates) {
        this.travelDates = travelDates;
    }

    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }

    public Long getConductorId() {
        return conductorId;
    }

    public void setConductorId(Long conductorId) {
        this.conductorId = conductorId;
    }
}
