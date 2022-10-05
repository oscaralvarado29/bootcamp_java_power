package com.rutas.conductor.creacion_de_rutas.domain.model;

public class RouteNeighborhood {
    private Long routeNeighborhoodId;
    private Long routeId;
    private Long neighborhoodId;
    private String meetingPoint;
    private Integer position;

    public RouteNeighborhood(Long routeNeighborhoodId, Long routeId, Long neighborhoodId, String meetingPoint, Integer position) {
        this.routeNeighborhoodId = routeNeighborhoodId;
        this.routeId = routeId;
        this.neighborhoodId = neighborhoodId;
        this.meetingPoint = meetingPoint;
        this.position = position;
    }

    public Long getRouteNeighborhoodId() {
        return routeNeighborhoodId;
    }

    public void setRouteNeighborhoodId(Long routeNeighborhoodId) {
        this.routeNeighborhoodId = routeNeighborhoodId;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public Long getNeighborhoodId() {
        return neighborhoodId;
    }

    public void setNeighborhoodId(Long neighborhoodId) {
        this.neighborhoodId = neighborhoodId;
    }

    public String getMeetingPoint() {
        return meetingPoint;
    }

    public void setMeetingPoint(String meetingPoint) {
        this.meetingPoint = meetingPoint;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
