package com.rutas.conductor.creacion_de_rutas.domain.model;

import java.util.Date;
import java.util.Map;

public class Travel {
    private Long travelId;
    private Long routeId;
    private Map<String, String> travelDates;

    public Travel(Long travelId, Long routeId, Map<String, String> travelDates) {
        this.travelId = travelId;
        this.routeId = routeId;
        this.travelDates = travelDates;
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

    public Map<String, String> getTravelDates() {
        return travelDates;
    }

    public void setTravelDates(Map<String, String> travelDates) {
        this.travelDates = travelDates;
    }
}
