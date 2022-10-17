package com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.adapter;

import com.rutas.conductor.creacion_de_rutas.domain.model.Travel;
import com.rutas.conductor.creacion_de_rutas.domain.spi.ITravelPersistencePort;
import com.rutas.conductor.creacion_de_rutas.infraestructure.exception.TravelAlreadyExistException;
import com.rutas.conductor.creacion_de_rutas.infraestructure.exception.TravelNotFoundException;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.entity.TravelEntity;
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
        List<TravelEntity> travelInDB = travelRepository.findByRouteId(travel.getRouteId());
        for (TravelEntity travelEntity : travelInDB) {
            if (travelEntity.getDate().equals(travel.getDate()) && travelEntity.getHour().equals(travel.getHour())) {
                throw new TravelAlreadyExistException();
            }
        }
        travelRepository.save(travelEntityMapper.toTravelEntity(travel));

    }

    @Override
    public void updateTravel(Travel travel) {

    }

    @Override
    public void deleteTravelOfARoute(Long routeId) {
        if (travelRepository.findByRouteId(routeId).isEmpty()) {
            throw new TravelNotFoundException();
        }
        travelRepository.deleteByRouteId(routeId);
    }

    @Override
    public void deleteTravel(Long routeId, String date) {
        if (travelRepository.findByRouteIdAndDate(routeId, date).isEmpty()) {
            throw new TravelNotFoundException();
        }
        travelRepository.deleteByRouteIdAndDate(routeId, date);
    }
    @Override
    public List<Travel> findTravelByRoute(Long routeId) {
        return travelEntityMapper.toTravelList(travelRepository.findByRouteId(routeId));
    }

    @Override
    public List<Travel> getAllTravel() {
        return travelEntityMapper.toTravelList(travelRepository.findAll());
    }
}
