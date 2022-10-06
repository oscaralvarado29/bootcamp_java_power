package com.rutas.conductor.creacion_de_rutas.domain.api;

import com.rutas.conductor.creacion_de_rutas.domain.model.DatesRoute;

import java.util.List;

public interface IDatesRouteServicePort {
    void saveDatesRoute(List<DatesRoute> datesRoute);
    void updateDatesRoute(DatesRoute datesRoute);
    void deleteDatesRouteOfARoute(Long routeId);
    DatesRoute getDateRoute(Long dateRouteId);
    List<DatesRoute> findDatesRouteByRoute(Long  routeId);
    List<DatesRoute> getAllDatesRoute();

}
