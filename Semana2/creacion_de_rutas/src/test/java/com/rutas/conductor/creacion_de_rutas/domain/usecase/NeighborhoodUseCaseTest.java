package com.rutas.conductor.creacion_de_rutas.domain.usecase;

import com.rutas.conductor.creacion_de_rutas.domain.factory.FactoryNeighborhoodDataTest;
import com.rutas.conductor.creacion_de_rutas.domain.model.Neighborhood;
import com.rutas.conductor.creacion_de_rutas.domain.spi.INeighborhoodPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class NeighborhoodUseCaseTest {

    @InjectMocks
    NeighborhoodUseCase neighborhoodUseCase;
    @Mock
    INeighborhoodPersistencePort neighborhoodPersistencePort;

    @Test
    void mustSaveNeighborhood() {
        //Given
        //yo como usuario hago la solictud para guardar un barrio
        Neighborhood expectedNeighborhood = FactoryNeighborhoodDataTest.getNeighborhood();
        Neighborhood neighborhood = FactoryNeighborhoodDataTest.getNeighborhood();

        //When
        //le envio los valores correctamente
        neighborhoodPersistencePort.saveNeighborhood(neighborhood);

        //Then
        //el sistema e guarda un nuevo barrio
        verify(neighborhoodPersistencePort).saveNeighborhood(any(Neighborhood.class));
    }

    @Test
    void updateNeighborhood() {
    }

    @Test
    void deleteNeighborhood() {
    }

    @Test
    void getNeighborhood() {
    }

    @Test
    void findNeighborhoodByName() {
    }

    @Test
    void getAllNeighborhoods() {
    }
}