package com.rutas.conductor.creacion_de_rutas.domain.model;

public class Travel {
    private Long travelId;
    private Long routeId;
    private String date;
    private String hour;

    public Travel(Long travelId, Long routeId, String date, String hour) {
        this.travelId = travelId;
        this.routeId = routeId;
        this.date = date;
        this.hour = hour;
    }

    public Long getTravelId() {
        return travelId;
    }

    public void setTravelId(Long travelId) {
        this.travelId = travelId;
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
