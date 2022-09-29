package com.rutas.conductor.creacion_de_rutas.domain.api;

import com.rutas.conductor.creacion_de_rutas.domain.model.Travel;

import java.util.List;

public interface ITravelServicePort {
    void saveTravel(Travel travel);
    void updateTravel(Travel travel);
    void deleteTravel(Long travelId);
    Travel getTravel(Long travelId);
    List<Travel> getAllTravels();
}
