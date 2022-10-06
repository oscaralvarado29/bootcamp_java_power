package com.rutas.conductor.creacion_de_rutas.domain.model;

public class DatesRoute {
    private Long dateRouteId;
    private Long routeId;
    private String date;
    private String hour;

    public DatesRoute(Long dateRouteId, Long routeId, String date, String hour) {
        this.dateRouteId = dateRouteId;
        this.routeId = routeId;
        this.date = date;
        this.hour = hour;
    }

    public Long getDateRouteId() {
        return dateRouteId;
    }

    public void setDateRouteId(Long dateRouteId) {
        this.dateRouteId = dateRouteId;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
}
