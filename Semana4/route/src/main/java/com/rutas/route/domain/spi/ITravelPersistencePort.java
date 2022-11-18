package com.rutas.route.domain.spi;

import com.rutas.route.domain.model.Travel;

import java.util.List;

public interface ITravelPersistencePort {
    void saveTravel(Travel travel);
    void updateTravel(Travel travel);
    void deleteTravelsOfARoute(Long routeId);
    void deleteTravel(Long routeId, String date);
    List<Travel> findTravelByRoute(Long  routeId);
    List<Travel> getAllTravel();
}
