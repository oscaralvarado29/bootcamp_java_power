package com.rutas.neighborhood.infraestructure.configuration;

import com.rutas.neighborhood.domain.api.INeighborhoodServicePort;
import com.rutas.neighborhood.domain.spi.INeighborhoodPersistencePort;
import com.rutas.neighborhood.domain.usecase.NeighborhoodUseCase;
import com.rutas.neighborhood.infraestructure.output.jpa.adapter.NeighborhoodJpaAdapter;
import com.rutas.neighborhood.infraestructure.output.jpa.mapper.INeighborhoodEntityMapper;
import com.rutas.neighborhood.infraestructure.output.jpa.repository.INeighborhoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final INeighborhoodRepository neighborhoodRepository;
    private final INeighborhoodEntityMapper neighborhoodEntityMapper;

    @Bean
    public INeighborhoodPersistencePort neighborhoodPersistencePort() {
        return new NeighborhoodJpaAdapter(neighborhoodRepository, neighborhoodEntityMapper);
    }

    @Bean
    public INeighborhoodServicePort neighborhoodServicePort() {
        return new NeighborhoodUseCase(neighborhoodPersistencePort());
    }
}
