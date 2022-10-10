package com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.mapper;

import com.rutas.conductor.creacion_de_rutas.domain.model.Neighborhood;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.entity.NeighborhoodEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface INeighborhoodEntityMapper {
    NeighborhoodEntity toNeighborhoodEntity(Neighborhood neighborhood);
    Neighborhood toNeighborhood(NeighborhoodEntity neighborhoodEntity);
    List<Neighborhood> toNeighborhoodList(List<NeighborhoodEntity> neighborhoodEntityList);
    List<NeighborhoodEntity> toNeighborhoodEntityList(List<Neighborhood> neighborhoodList);
}
