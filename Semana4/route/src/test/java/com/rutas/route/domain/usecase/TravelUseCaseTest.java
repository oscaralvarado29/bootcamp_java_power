package com.rutas.route.domain.usecase;

import com.rutas.route.domain.exception.DateAndHourNotPresentException;
import com.rutas.route.domain.factory.FactoryTravelDataTest;
import com.rutas.route.domain.model.Travel;
import com.rutas.route.domain.spi.ITravelPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class TravelUseCaseTest {

    @InjectMocks
    TravelUseCase travelUseCase;
    @Mock
    ITravelPersistencePort travelPersistencePort;
    private Travel travel;

    @BeforeEach
    void setUp() {

        travel = FactoryTravelDataTest.getTravel();
    }

    @Test
    void mustSaveTravelInDB() {
        List<Travel> travelList = FactoryTravelDataTest.getTravelList();
        travelUseCase.saveTravel(travelList);
        verify(travelPersistencePort,times(2)).saveTravel(any(Travel.class));
    }

    @Test
    void trowDateAndHourNotPresentExceptionWhenTravelListSizeIsZaro() {
        List<Travel> travelList = new ArrayList<>();
        assertThrows(DateAndHourNotPresentException.class, () -> travelUseCase.saveTravel(travelList));
    }
    @Test
    void mustUpdateTravel() {
        travelUseCase.updateTravel(travel);
        verify(travelPersistencePort).updateTravel(any(Travel.class));
    }

    @Test
    void deleteTravelsOfARoute() {
        travelUseCase.deleteTravelsOfARoute(travel.getRouteId());
        verify(travelPersistencePort).deleteTravelsOfARoute(travel.getRouteId());
    }

    @Test
    void deleteTravel() {
        travelUseCase.deleteTravel(travel.getRouteId(),travel.getDate());
        verify(travelPersistencePort).deleteTravel(travel.getRouteId(),travel.getDate());
    }

    @Test
    void findTravelByRoute() {
        travelUseCase.findTravelByRoute(travel.getRouteId());
        verify(travelPersistencePort).findTravelByRoute(travel.getRouteId());
    }

    @Test
    void getAllTravel() {
        travelUseCase.getAllTravel();
        verify(travelPersistencePort).getAllTravel();
    }
}