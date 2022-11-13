package com.rutas.neighborhood.application.mapper;

import com.rutas.neighborhood.application.dto.NeighborhoodResponse;
import com.rutas.neighborhood.domain.model.Neighborhood;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface NeighborhoodResponseMapper {
    NeighborhoodResponse toNeighborhoodResponse(Neighborhood neighborhood);
    List<NeighborhoodResponse> toNeighborhoodResponseList(List<Neighborhood> neighborhoodList);
}
