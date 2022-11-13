package com.rutas.neighborhood.infraestructure.output.jpa.mapper;

import com.rutas.neighborhood.domain.model.Neighborhood;
import com.rutas.neighborhood.infraestructure.output.jpa.entity.NeighborhoodEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface INeighborhoodEntityMapper {
    NeighborhoodEntity toNeighborhoodEntity(Neighborhood neighborhood);
    Neighborhood toNeighborhood(NeighborhoodEntity neighborhoodEntity);
    Neighborhood toNeighborhoodOfOptional(Optional<NeighborhoodEntity> neighborhoodEntity);
    List<Neighborhood> toNeighborhoodList(List<NeighborhoodEntity> neighborhoodEntityList);
    List<NeighborhoodEntity> toNeighborhoodEntityList(List<Neighborhood> neighborhoodList);
}
