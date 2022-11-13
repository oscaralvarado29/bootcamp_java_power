package com.rutas.conductor.creacion_de_rutas.usecase;

import com.rutas.conductor.creacion_de_rutas.domain.exceptions.DateAndHourNotPresentException;
import com.rutas.conductor.creacion_de_rutas.domain.factory.FactoryTravelDataTest;
import com.rutas.conductor.creacion_de_rutas.domain.model.Travel;
import com.rutas.conductor.creacion_de_rutas.domain.spi.ITravelPersistencePort;
import com.rutas.conductor.creacion_de_rutas.domain.usecase.TravelUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
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
    void mustSaveTravel() {
        List<Travel> travelList = new ArrayList<>();
        travelList.add(travel);
        travelUseCase.saveTravel(travelList);
        verify(travelPersistencePort).saveTravel(any(Travel.class));
    }

    @Test
    void trowDateAndHourNotPresentExceptionWhenTravelListSizeIsZaro() {
        List<Travel> travelList = new ArrayList<>();
        assertThrows(DateAndHourNotPresentException.class, () -> travelUseCase.saveTravel(travelList));
    }
    @Test
    void updateTravel() {
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