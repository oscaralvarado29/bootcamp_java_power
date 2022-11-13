package com.rutas.conductor.creacion_de_rutas.usecase;

import com.rutas.conductor.creacion_de_rutas.domain.exceptions.QuotaNotValidException;
import com.rutas.conductor.creacion_de_rutas.domain.factory.FactoryRouteDataTest;
import com.rutas.conductor.creacion_de_rutas.domain.model.Route;
import com.rutas.conductor.creacion_de_rutas.domain.spi.IRoutePersistencePort;
import com.rutas.conductor.creacion_de_rutas.domain.usecase.RouteUseCase;
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
    private Route route;

    @BeforeEach
    void setUp() {
        route = FactoryRouteDataTest.getRoute();
    }

    @Test
    void mustSaveRoute() {
        routeUseCase.saveRoute(route);
        verify(routePersistencePort).saveRoute(any(Route.class));
    }

    @Test
    void trowQuotaNotValidExceptionWhenQuotaIsLessThanOneOrGreaterThanFour() {
        route.setQuota(0);
        assertThrows(QuotaNotValidException.class, () -> routeUseCase.saveRoute(route));
    }

    @Test
    void updateRoute() {
        routeUseCase.updateRoute(route);
        verify(routePersistencePort).updateRoute(any(Route.class));
    }

    @Test
    void deleteRoute() {
        routeUseCase.deleteRoute(route.getRouteName());
        verify(routePersistencePort).deleteRoute(route.getRouteName());
    }

    @Test
    void findRouteByName() {
        routeUseCase.findRouteByName(route.getRouteName());
        verify(routePersistencePort).findRouteByName(route.getRouteName());
    }

    @Test
    void getAllRoutes() {
        routeUseCase.getAllRoutes();
        verify(routePersistencePort).getAllRoutes();
    }
}