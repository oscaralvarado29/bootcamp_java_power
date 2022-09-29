package com.rutas.conductor.creacion_de_rutas.domain.model;

import java.util.Date;

public class Travel {
    private Long travelId;
    private Long routeId;
    private Date travelDate;

    public Travel(Long travelId, Long routeId, Date travelDate) {
        this.travelId = travelId;
        this.routeId = routeId;
        this.travelDate = travelDate;
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

    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }
}
