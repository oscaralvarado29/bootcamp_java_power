package com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.adapter;

import com.rutas.conductor.creacion_de_rutas.domain.model.Travel;
import com.rutas.conductor.creacion_de_rutas.domain.spi.ITravelPersistencePort;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.mapper.ITravelEntityMapper;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.repository.ITravelRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TravelJpaAdapter implements ITravelPersistencePort {

    private final ITravelRepository travelRepository;
    private final ITravelEntityMapper travelEntityMapper;

    @Override
    public void saveTravel(Travel travel) {

    }

    @Override
    public void updateTravel(Travel travel) {

    }

    @Override
    public void deleteTravelOfARoute(Long routeId) {

    }

    @Override
    public void deleteTravel(Long routeId, String date) {

    }

    @Override
    public Travel getTravel(Long dateRouteId) {
        return null;
    }

    @Override
    public List<Travel> findTravelByRoute(Long routeId) {
        return null;
    }

    @Override
    public List<Travel> getAllTravel() {
        return null;
    }
}
