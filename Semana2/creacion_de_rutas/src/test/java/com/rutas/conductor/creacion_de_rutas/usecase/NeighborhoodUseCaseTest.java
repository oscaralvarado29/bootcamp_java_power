package com.rutas.conductor.creacion_de_rutas.usecase;

import com.rutas.conductor.creacion_de_rutas.domain.factory.FactoryNeighborhoodDataTest;
import com.rutas.conductor.creacion_de_rutas.domain.model.Neighborhood;
import com.rutas.conductor.creacion_de_rutas.domain.spi.INeighborhoodPersistencePort;
import com.rutas.conductor.creacion_de_rutas.domain.usecase.NeighborhoodUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class NeighborhoodUseCaseTest {

    @InjectMocks
    NeighborhoodUseCase neighborhoodUseCase;
    @Mock
    INeighborhoodPersistencePort neighborhoodPersistencePort;
    private Neighborhood neighborhood;

    @BeforeEach
    void setUp() {
        neighborhood = FactoryNeighborhoodDataTest.getNeighborhood();
    }
    @Test
    void mustSaveNeighborhood() {
        neighborhoodUseCase.saveNeighborhood(neighborhood);
        verify(neighborhoodPersistencePort).saveNeighborhood(any(Neighborhood.class));
    }

    @Test
    void updateNeighborhood() {
        neighborhoodUseCase.updateNeighborhood(neighborhood);
        verify(neighborhoodPersistencePort).updateNeighborhood(any(Neighborhood.class));
    }

    @Test
    void deleteNeighborhood() {
        neighborhoodUseCase.deleteNeighborhood(neighborhood.getNeighborhoodName());
        verify(neighborhoodPersistencePort).deleteNeighborhood(neighborhood.getNeighborhoodName());
    }

    @Test
    void getNeighborhood() {
        neighborhoodUseCase.getNeighborhood(neighborhood.getNeighborhoodId());
        verify(neighborhoodPersistencePort).getNeighborhood(neighborhood.getNeighborhoodId());
    }

    @Test
    void findNeighborhoodByName() {
        neighborhoodUseCase.findNeighborhoodByName(neighborhood.getNeighborhoodName());
        verify(neighborhoodPersistencePort).findNeighborhoodByName(neighborhood.getNeighborhoodName());
    }

    @Test
    void getAllNeighborhoods() {
        neighborhoodUseCase.getAllNeighborhoods();
        verify(neighborhoodPersistencePort).getAllNeighborhoods();
    }
}