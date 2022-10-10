package com.rutas.conductor.creacion_de_rutas.infraestructure.configuration;

import com.rutas.conductor.creacion_de_rutas.domain.api.INeighborhoodServicePort;
import com.rutas.conductor.creacion_de_rutas.domain.api.IRouteNeighborhoodServicePort;
import com.rutas.conductor.creacion_de_rutas.domain.api.IRouteServicePort;
import com.rutas.conductor.creacion_de_rutas.domain.api.ITravelServicePort;
import com.rutas.conductor.creacion_de_rutas.domain.api.IUserServicePort;
import com.rutas.conductor.creacion_de_rutas.domain.spi.INeighborhoodPersistencePort;
import com.rutas.conductor.creacion_de_rutas.domain.spi.IRouteNeighborhoodPersistencePort;
import com.rutas.conductor.creacion_de_rutas.domain.spi.IRoutePersistencePort;
import com.rutas.conductor.creacion_de_rutas.domain.spi.ITravelPersistencePort;
import com.rutas.conductor.creacion_de_rutas.domain.spi.IUserPersistencePort;
import com.rutas.conductor.creacion_de_rutas.domain.usecase.NeighborhoodUseCase;
import com.rutas.conductor.creacion_de_rutas.domain.usecase.RouteNeighborhoodUseCase;
import com.rutas.conductor.creacion_de_rutas.domain.usecase.RouteUseCase;
import com.rutas.conductor.creacion_de_rutas.domain.usecase.TravelUseCase;
import com.rutas.conductor.creacion_de_rutas.domain.usecase.UserUseCase;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.adapter.NeighborhoodJpaAdapter;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.adapter.RouteJpaAdapter;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.adapter.RouteNeighborhoodJpaAdapter;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.adapter.TravelJpaAdapter;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.adapter.UserJpaAdapter;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.mapper.INeighborhoodEntityMapper;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.mapper.IRouteEntityMapper;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.mapper.IRouteNeighborhoodEntityMapper;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.mapper.ITravelEntityMapper;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.mapper.IUserEntityMapper;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.repository.INeighborhoodRepository;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.repository.IRouteNeighborhoodRepository;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.repository.IRouteRepository;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.repository.ITravelRepository;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final INeighborhoodRepository neighborhoodRepository;
    private final INeighborhoodEntityMapper neighborhoodEntityMapper;
    private final IRouteNeighborhoodRepository routeNeighborhoodRepository;
    private final IRouteNeighborhoodEntityMapper routeNeighborhoodEntityMapper;
    private final IRouteRepository routeRepository;
    private final IRouteEntityMapper routeEntityMapper;
    private final ITravelRepository travelRepository;
    private final ITravelEntityMapper travelEntityMapper;
    private final IUserRepository userRepository;
    private final IUserEntityMapper  userEntityMapper;

    @Bean
    public INeighborhoodPersistencePort neighborhoodPersistencePort() {
        return new NeighborhoodJpaAdapter(neighborhoodRepository, neighborhoodEntityMapper);
    }

    @Bean
    public INeighborhoodServicePort neighborhoodServicePort() {
        return new NeighborhoodUseCase(neighborhoodPersistencePort());
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

    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserJpaAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort());
    }
}
