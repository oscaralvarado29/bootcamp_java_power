package com.rutas.neighborhood.application.mapper;

import com.rutas.neighborhood.application.dto.NeighborhoodRequest;
import com.rutas.neighborhood.domain.model.Neighborhood;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface NeighborhoodRequestMapper {
    Neighborhood toNeighborhood(NeighborhoodRequest neighborhoodRequest);

}
