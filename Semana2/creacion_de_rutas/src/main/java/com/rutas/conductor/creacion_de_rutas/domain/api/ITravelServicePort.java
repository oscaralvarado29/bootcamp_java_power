package com.rutas.conductor.creacion_de_rutas.domain.api;

import com.rutas.conductor.creacion_de_rutas.domain.model.Travel;

import java.util.List;

public interface ITravelServicePort {
    void saveTravel(List<Travel> travel);
    void updateTravel(Travel travel);
    void deleteTravelsOfARoute(Long routeId);
    void deleteTravel(Long routeId, String date);
    List<Travel> findTravelByRoute(Long  routeId);
    List<Travel> getAllTravel();

}
