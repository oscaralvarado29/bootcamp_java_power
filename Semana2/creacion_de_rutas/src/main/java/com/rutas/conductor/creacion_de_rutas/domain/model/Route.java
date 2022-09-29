package com.rutas.conductor.creacion_de_rutas.domain.model;

import java.util.List;

public class Route {
    private Long routeId;
    private String description;
    private String origin;
    private String destination;
    private List<String> stops;
    private Long quota;
    private Long conductorId;

    public Route(Long routeId, String description, String origin, String destination, List<String> stops, Long quota, Long conductorId) {
        this.routeId = routeId;
        this.description = description;
        this.origin = origin;
        this.destination = destination;
        this.stops = stops;
        this.quota = quota;
        this.conductorId = conductorId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<String> getStops() {
        return stops;
    }

    public void setStops(List<String> stops) {
        this.stops = stops;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getQuota() {
        return quota;
    }

    public void setQuota(Long quota) {
        this.quota = quota;
    }

    public Long getConductorId() {
        return conductorId;
    }

    public void setConductorId(Long conductorId) {
        this.conductorId = conductorId;
    }
}
