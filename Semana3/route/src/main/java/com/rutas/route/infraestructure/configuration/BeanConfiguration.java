package com.rutas.route.infraestructure.configuration;

import com.rutas.route.domain.api.INeighborhoodServicePort;
import com.rutas.route.domain.api.IRouteNeighborhoodServicePort;
import com.rutas.route.domain.api.IRouteServicePort;
import com.rutas.route.domain.api.ITravelServicePort;
import com.rutas.route.domain.api.IUserServicePort;
import com.rutas.route.domain.spi.INeighborhoodPersistancePort;
import com.rutas.route.domain.spi.IRouteNeighborhoodPersistencePort;
import com.rutas.route.domain.spi.IRoutePersistencePort;
import com.rutas.route.domain.spi.ITravelPersistencePort;
import com.rutas.route.domain.spi.IUserPersistancePort;
import com.rutas.route.domain.usecase.NeighborhoodUseCase;
import com.rutas.route.domain.usecase.RouteNeighborhoodUseCase;
import com.rutas.route.domain.usecase.RouteUseCase;
import com.rutas.route.domain.usecase.TravelUseCase;
import com.rutas.route.domain.usecase.UserUseCase;
import com.rutas.route.infraestructure.output.client.NeigborhoodClient;
import com.rutas.route.infraestructure.output.client.UserClient;
import com.rutas.route.infraestructure.output.feing.adapter.NeighborhoodFeingAdapter;
import com.rutas.route.infraestructure.output.feing.adapter.UserFeingAdapter;
import com.rutas.route.infraestructure.output.jpa.adapter.RouteJpaAdapter;
import com.rutas.route.infraestructure.output.jpa.adapter.RouteNeighborhoodJpaAdapter;
import com.rutas.route.infraestructure.output.jpa.adapter.TravelJpaAdapter;
import com.rutas.route.infraestructure.output.feing.mapper.NeighborhoodRequestMapper;
import com.rutas.route.infraestructure.output.jpa.mapper.RouteEntityMapper;
import com.rutas.route.infraestructure.output.jpa.mapper.RouteNeighborhoodEntityMapper;
import com.rutas.route.infraestructure.output.jpa.mapper.TravelEntityMapper;
import com.rutas.route.infraestructure.output.feing.mapper.UserRequestMapper;
import com.rutas.route.infraestructure.output.jpa.repository.IRouteNeighborhoodRepository;
import com.rutas.route.infraestructure.output.jpa.repository.IRouteRepository;
import com.rutas.route.infraestructure.output.jpa.repository.ITravelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IRouteNeighborhoodRepository routeNeighborhoodRepository;
    private final RouteNeighborhoodEntityMapper routeNeighborhoodEntityMapper;
    private final IRouteRepository routeRepository;
    private final RouteEntityMapper routeEntityMapper;
    private final ITravelRepository travelRepository;
    private final TravelEntityMapper travelEntityMapper;
    private final UserClient userClient;
    private final UserRequestMapper userRequestMapper;
    private final NeigborhoodClient neigborhoodClient;
    private final NeighborhoodRequestMapper neighborhoodRequestMapper;

    @Bean
    public IUserPersistancePort userPersistancePort() {
        return new UserFeingAdapter(userClient, userRequestMapper);
    }

    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistancePort());
    }

    @Bean
    public INeighborhoodPersistancePort neighborhoodPersistancePort() {
        return new NeighborhoodFeingAdapter(neigborhoodClient, neighborhoodRequestMapper);
    }

    @Bean
    public INeighborhoodServicePort neighborhoodServicePort() {
        return new NeighborhoodUseCase(neighborhoodPersistancePort());
    }

    @Bean
    public IRouteNeighborhoodPersistencePort routeNeighborhoodPersistencePort() {
        return new RouteNeighborhoodJpaAdapter(routeNeighborhoodRepository, routeNeighborhoodEntityMapper);
    }

    @Bean
    public IRouteNeighborhoodServicePort routeNeighborhoodServicePort() {
        return new RouteNeighborhoodUseCase(routeNeighborhoodPersistencePort());
    }

    @Bean
    public IRoutePersistencePort routePersistencePort() {
        return new RouteJpaAdapter(routeRepository, routeEntityMapper);
    }

    @Bean
    public IRouteServicePort routeServicePort() {
        return new RouteUseCase(routePersistencePort());
    }

    @Bean
    public ITravelPersistencePort travelPersistencePort() {
        return new TravelJpaAdapter(travelRepository, travelEntityMapper);
    }

    @Bean
    public ITravelServicePort travelServicePort() {
        return new TravelUseCase(travelPersistencePort());
    }
}
