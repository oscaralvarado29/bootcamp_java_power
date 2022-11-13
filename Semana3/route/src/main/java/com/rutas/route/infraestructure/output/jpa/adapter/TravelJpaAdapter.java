package com.rutas.route.infraestructure.output.jpa.adapter;

import com.rutas.route.domain.model.Travel;
import com.rutas.route.domain.spi.ITravelPersistencePort;
import com.rutas.route.infraestructure.exception.TravelAlreadyExistException;
import com.rutas.route.infraestructure.exception.TravelNotFoundException;
import com.rutas.route.infraestructure.output.jpa.entity.TravelEntity;
import com.rutas.route.infraestructure.output.jpa.mapper.TravelEntityMapper;
import com.rutas.route.infraestructure.output.jpa.repository.ITravelRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TravelJpaAdapter implements ITravelPersistencePort {

    private final ITravelRepository travelRepository;
    private final TravelEntityMapper travelEntityMapper;

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
    public void deleteTravelsOfARoute(Long routeId) {
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

