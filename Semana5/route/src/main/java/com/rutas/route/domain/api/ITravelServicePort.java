package com.rutas.route.domain.api;

import com.rutas.route.domain.model.Travel;

import java.util.List;

public interface ITravelServicePort {
    void saveTravel(List<Travel> travel);
    void updateTravel(Travel travel);
    void deleteTravelsOfARoute(Long routeId);
    void deleteTravel(Long routeId, String date);
    List<Travel> findTravelByRoute(Long  routeId);
    List<Travel> getAllTravel();
}
