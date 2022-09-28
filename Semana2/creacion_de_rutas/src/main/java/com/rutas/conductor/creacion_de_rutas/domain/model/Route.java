package com.rutas.conductor.creacion_de_rutas.domain.model;

public class Route {
    private Long routeId;
    private String description;
    private Long quota;
    private Long conductorId;

    public Route(Long routeId, String description, Long quota, Long conductorId) {
        this.routeId = routeId;
        this.description = description;
        this.quota = quota;
        this.conductorId = conductorId;
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
