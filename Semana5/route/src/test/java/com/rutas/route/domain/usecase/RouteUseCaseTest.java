package com.rutas.route.domain.usecase;

import com.rutas.route.domain.exception.QuotaNotValidException;
import com.rutas.route.domain.model.Route;
import com.rutas.route.domain.spi.IRoutePersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class RouteUseCaseTest {

    @InjectMocks
    RouteUseCase routeUseCase;
    @Mock
    IRoutePersistencePort routePersistencePort;
    private final Route route = new Route();

    @BeforeEach
    void setUp() {
        route.setRouteId(1L);
        route.setRouteName("Ruta 1");
        route.setDescription("Ruta 1 description");
        route.setOriginNeighborhood(1L);
        route.setDestinationNeighborhood(2L);
        route.setQuota(3);
        route.setConductorId(1L);
    }

    @Test
    void mustSaveRouteInDB() {
        routeUseCase.saveRoute(route);
        verify(routePersistencePort).saveRoute(any(Route.class));
    }

    @Test
    void trowQuotaNotValidExceptionWhenQuotaIsLessThanOneOrGreaterThanFour() {
        route.setQuota(0);
        assertThrows(QuotaNotValidException.class, () -> routeUseCase.saveRoute(route));
    }

    @Test
    void mustUpdateRouteThatIsInDB() {
        routeUseCase.updateRoute(route);
        verify(routePersistencePort).updateRoute(any(Route.class));
    }

    @Test
    void mustDeleteRouteOfDB() {
        routeUseCase.deleteRoute(route.getRouteName());
        verify(routePersistencePort).deleteRoute(route.getRouteName());
    }

    @Test
    void mustFindRouteByNameInDBAndIfExistBringIt() {
        routeUseCase.findRouteByName(route.getRouteName());
        verify(routePersistencePort).findRouteByName(route.getRouteName());
    }

    @Test
    void mustGetAllRoutesOfDB() {
        routeUseCase.getAllRoutes();
        verify(routePersistencePort).getAllRoutes();
    }
}