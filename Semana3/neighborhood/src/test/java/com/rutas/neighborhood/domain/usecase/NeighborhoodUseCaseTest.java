package com.rutas.neighborhood.domain.usecase;

import com.rutas.neighborhood.domain.model.Neighborhood;
import com.rutas.neighborhood.domain.spi.INeighborhoodPersistencePort;
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
    private final Neighborhood neighborhood = new Neighborhood();

    @BeforeEach
    void setUp() {
        neighborhood.setNeighborhoodId(1L);
        neighborhood.setNeighborhoodName("Neighborhood 1");
        neighborhood.setNeighborhoodDescription("Neighborhood 1 description");
    }
    @Test
    void mustSaveNeighborhoodInDB() {
        neighborhoodUseCase.saveNeighborhood(neighborhood);
        verify(neighborhoodPersistencePort).saveNeighborhood(any(Neighborhood.class));
    }

    @Test
    void mustUpdateNeighborhoodThatIsInDB() {
        neighborhoodUseCase.updateNeighborhood(neighborhood);
        verify(neighborhoodPersistencePort).updateNeighborhood(any(Neighborhood.class));
    }

    @Test
    void mustDeleteNeighborhoodOfDB() {
        neighborhoodUseCase.deleteNeighborhood(neighborhood.getNeighborhoodName());
        verify(neighborhoodPersistencePort).deleteNeighborhood(neighborhood.getNeighborhoodName());
    }

    @Test
    void mustGetNeighborhoodOfDB() {
        neighborhoodUseCase.getNeighborhood(neighborhood.getNeighborhoodId());
        verify(neighborhoodPersistencePort).getNeighborhood(neighborhood.getNeighborhoodId());
    }

    @Test
    void mustFindNeighborhoodByNameInDBAndIfExistBringIt() {
        neighborhoodUseCase.findNeighborhoodByName(neighborhood.getNeighborhoodName());
        verify(neighborhoodPersistencePort).findNeighborhoodByName(neighborhood.getNeighborhoodName());
    }

    @Test
    void mustGetAllNeighborhoodsOfDB() {
        neighborhoodUseCase.getAllNeighborhoods();
        verify(neighborhoodPersistencePort).getAllNeighborhoods();
    }
}