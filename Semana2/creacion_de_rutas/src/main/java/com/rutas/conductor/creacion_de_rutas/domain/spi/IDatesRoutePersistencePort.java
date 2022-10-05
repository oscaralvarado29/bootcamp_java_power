package com.rutas.conductor.creacion_de_rutas.domain.spi;

import com.rutas.conductor.creacion_de_rutas.domain.model.DatesRoute;

import java.util.List;

public interface IDatesRoutePersistencePort {
    void saveDatesRoute(DatesRoute datesRoute);
    void updateDatesRoute(DatesRoute datesRoute);
    void deleteADateRoute(Long dateRouteId);
    void deleteDatesRouteOfRoute(Long routeId);
    DatesRoute getDateRoute(Long dateRouteId);
    List<DatesRoute> findDatesRouteByRoute(Long  routeId);
    List<DatesRoute> getAllDatesRoute();
}
