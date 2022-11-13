package com.rutas.conductor.creacion_de_rutas.usecase;

import com.rutas.conductor.creacion_de_rutas.domain.exceptions.RepeatedNeighborhoodsException;
import com.rutas.conductor.creacion_de_rutas.domain.factory.FactoryRouteNeighborhoodDataTest;
import com.rutas.conductor.creacion_de_rutas.domain.model.RouteNeighborhood;
import com.rutas.conductor.creacion_de_rutas.domain.spi.IRouteNeighborhoodPersistencePort;
import com.rutas.conductor.creacion_de_rutas.domain.usecase.RouteNeighborhoodUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class RouteNeighborhoodUseCaseTest {
    @InjectMocks
    RouteNeighborhoodUseCase routeNeighborhoodUseCase;
    @Mock
    IRouteNeighborhoodPersistencePort routeNeighborhoodPersistencePort;
    private RouteNeighborhood routeNeighborhood;

    @BeforeEach
    void setUp() {
        routeNeighborhood = FactoryRouteNeighborhoodDataTest.getRouteNeighborhood();
    }

    @Test
    void mustSaveRouteNeighborhood() {
        List<RouteNeighborhood> routeNeighborhoods = FactoryRouteNeighborhoodDataTest.getRouteNeighborhoodsList();
        routeNeighborhoodUseCase.saveRouteNeighborhood(routeNeighborhoods);
        verify(routeNeighborhoodPersistencePort,times(2)).saveRouteNeighborhood(any(RouteNeighborhood.class));
    }

    @Test
    void trowRepeatedNeighborhoodsExceptionWhenRouteNeighborhoodListHaveNeighborhoodsRepeats() {
        List<RouteNeighborhood> routeNeighborhoods = FactoryRouteNeighborhoodDataTest.getRouteNeighborhoodsList();
        routeNeighborhoods.add(routeNeighborhood);
        assertThrows(RepeatedNeighborhoodsException.class, () -> routeNeighborhoodUseCase.saveRouteNeighborhood(routeNeighborhoods));
    }
    @Test
    void updateRouteNeighborhood() {
        routeNeighborhoodUseCase.updateRouteNeighborhood(routeNeighborhood);
        verify(routeNeighborhoodPersistencePort).updateRouteNeighborhood(any(RouteNeighborhood.class));
    }

    @Test
    void deleteRouteNeighborhoodByRoute() {
        routeNeighborhoodUseCase.deleteRouteNeighborhoodByRoute(routeNeighborhood.getRouteId());
        verify(routeNeighborhoodPersistencePort).deleteRouteNeighborhoodByRoute(routeNeighborhood.getRouteId());
    }

    @Test
    void getAllRouteNeighborhoods() {
        routeNeighborhoodUseCase.getAllRouteNeighborhoods();
        verify(routeNeighborhoodPersistencePort).getAllRouteNeighborhoods();
    }

    @Test
    void findRouteNeighborhoodByRoute() {
        routeNeighborhoodUseCase.findRouteNeighborhoodByRoute(routeNeighborhood.getRouteId());
        verify(routeNeighborhoodPersistencePort).findRouteNeighborhoodByRoute(routeNeighborhood.getRouteId());
    }
}