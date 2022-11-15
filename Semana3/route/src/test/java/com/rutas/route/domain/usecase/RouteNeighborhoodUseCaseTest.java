package com.rutas.route.domain.usecase;

import com.rutas.route.domain.exception.RepeatedNeighborhoodsException;
import com.rutas.route.domain.factory.FactoryRouteNeighborhoodDataTest;
import com.rutas.route.domain.model.RouteNeighborhood;
import com.rutas.route.domain.spi.IRouteNeighborhoodPersistencePort;
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
    void mustSaveRouteNeighborhoodInDB() {
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
    void mustUpdateRouteNeighborhoodThatIsInDB() {
        routeNeighborhoodUseCase.updateRouteNeighborhood(routeNeighborhood);
        verify(routeNeighborhoodPersistencePort).updateRouteNeighborhood(any(RouteNeighborhood.class));
    }

    @Test
    void mustDeleteRouteNeighborhoodByRouteOfDB() {
        routeNeighborhoodUseCase.deleteRouteNeighborhoodByRoute(routeNeighborhood.getRouteId());
        verify(routeNeighborhoodPersistencePort).deleteRouteNeighborhoodByRoute(routeNeighborhood.getRouteId());

    }

    @Test
    void mustGetAllRouteNeighborhoodsOfDB() {
        routeNeighborhoodUseCase.getAllRouteNeighborhoods();
        verify(routeNeighborhoodPersistencePort).getAllRouteNeighborhoods();
    }

    @Test
    void mustFindRouteNeighborhoodByRouteInDBAndIfExistBringIt() {
        routeNeighborhoodUseCase.findRouteNeighborhoodByRoute(routeNeighborhood.getRouteId());
        verify(routeNeighborhoodPersistencePort).findRouteNeighborhoodByRoute(routeNeighborhood.getRouteId());
    }
}