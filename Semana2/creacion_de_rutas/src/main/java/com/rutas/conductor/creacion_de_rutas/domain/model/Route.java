package com.rutas.conductor.creacion_de_rutas.domain.model;

public class Route {
    private Long routeId;
    private String routeName;
    private String description;
    private Long originNeighborhood;
    private Long destinationNeighborhood;
    private Integer quota;
    private Long conductorId;

    public Route(Long routeId, String routeName, String description, Long originNeighborhood, Long destinationNeighborhood, Integer quota, Long conductorId) {
        this.routeId = routeId;
        this.routeName = routeName;
        this.description = description;
        this.originNeighborhood = originNeighborhood;
        this.destinationNeighborhood = destinationNeighborhood;
        this.quota = quota;
        this.conductorId = conductorId;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
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

    public Long getOriginNeighborhood() {
        return originNeighborhood;
    }

    public void setOriginNeighborhood(Long originNeighborhood) {
        this.originNeighborhood = originNeighborhood;
    }

    public Long getDestinationNeighborhood() {
        return destinationNeighborhood;
    }

    public void setDestinationNeighborhood(Long destinationNeighborhood) {
        this.destinationNeighborhood = destinationNeighborhood;
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
