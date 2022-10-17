package com.rutas.conductor.creacion_de_rutas.domain.usecase;

import com.rutas.conductor.creacion_de_rutas.domain.factory.FactoryNeighborhoodDataTest;
import com.rutas.conductor.creacion_de_rutas.domain.model.Neighborhood;
import com.rutas.conductor.creacion_de_rutas.domain.spi.INeighborhoodPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class NeighborhoodUseCaseTest {

    @InjectMocks
    NeighborhoodUseCase neighborhoodUseCase;
    @Mock
    INeighborhoodPersistencePort neighborhoodPersistencePort;

    @Test
    void mustSaveNeighborhood() {
        Neighborhood neighborhood = FactoryNeighborhoodDataTest.getNeighborhood();
        neighborhoodPersistencePort.saveNeighborhood(neighborhood);
        verify(neighborhoodPersistencePort).saveNeighborhood(any(Neighborhood.class));
    }

    @Test
    void updateNeighborhood() {
        Neighborhood neighborhood = FactoryNeighborhoodDataTest.getNeighborhood();
        neighborhoodPersistencePort.updateNeighborhood(neighborhood);
        verify(neighborhoodPersistencePort).updateNeighborhood(any(Neighborhood.class));
    }

    @Test
    void deleteNeighborhood() {
        Neighborhood neighborhood = FactoryNeighborhoodDataTest.getNeighborhood();
        neighborhoodPersistencePort.deleteNeighborhood(neighborhood.getNeighborhoodName());
        verify(neighborhoodPersistencePort).deleteNeighborhood(neighborhood.getNeighborhoodName());
    }

    @Test
    void getNeighborhood() {
        Neighborhood neighborhood = FactoryNeighborhoodDataTest.getNeighborhood();
        neighborhoodPersistencePort.getNeighborhood(neighborhood.getNeighborhoodId());
        verify(neighborhoodPersistencePort).getNeighborhood(neighborhood.getNeighborhoodId());
    }

    @Test
    void findNeighborhoodByName() {
        Neighborhood neighborhood = FactoryNeighborhoodDataTest.getNeighborhood();
        neighborhoodPersistencePort.findByName(neighborhood.getNeighborhoodName());
        verify(neighborhoodPersistencePort).findByName(neighborhood.getNeighborhoodName());
    }

    @Test
    void getAllNeighborhoods() {
        neighborhoodPersistencePort.getAllNeighborhoods();
        verify(neighborhoodPersistencePort, times(1)).getAllNeighborhoods();
    }
}