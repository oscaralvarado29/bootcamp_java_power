package com.rutas.conductor.creacion_de_rutas.domain.spi;

import com.rutas.conductor.creacion_de_rutas.domain.model.Travel;

import java.util.List;

public interface ITravelPersistencePort {
    void saveTravel(Travel travel);
    void updateTravel(Travel travel);
    void deleteTravelOfARoute(Long routeId);
    void deleteTravel(Long routeId, String date);
    List<Travel> findTravelByRoute(Long  routeId);
    List<Travel> getAllTravel();
}
