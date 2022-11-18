package com.rutas.route.domain.usecase;

import com.rutas.route.domain.model.Neighborhood;
import com.rutas.route.domain.spi.INeighborhoodPersistancePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class NeighborhoodUseCaseTest {

    @InjectMocks
    NeighborhoodUseCase neighborhoodUseCase;
    @Mock
    INeighborhoodPersistancePort neighborhoodPersistencePort;
    private final Neighborhood neighborhood = new Neighborhood();

    @BeforeEach
    void setUp() {
        neighborhood.setNeighborhoodId(1L);
        neighborhood.setNeighborhoodName("Neighborhood 1");
        neighborhood.setNeighborhoodDescription("Neighborhood 1 description");
    }

    @Test
    void mustGetNeighborhoodOfDB() {
        neighborhoodUseCase.getNeighborhood(neighborhood.getNeighborhoodId());
        verify(neighborhoodPersistencePort).getNeighborhood(neighborhood.getNeighborhoodId());
    }

    @Test
    void getAllNeighborhoods() {
        neighborhoodUseCase.getAllNeighborhoods();
        verify(neighborhoodPersistencePort).getAllNeighborhoods();
    }
}