package com.rutas.neighborhood.application.mapper;

import com.rutas.neighborhood.application.dto.NeighborhoodClientResponse;
import com.rutas.neighborhood.domain.model.Neighborhood;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface NeighborhoodClientResponseMapper {
    NeighborhoodClientResponse toNeighborhoodClientResponse(Neighborhood neighborhood);
    List<NeighborhoodClientResponse> toNeighborhoodClientResponseList(List<Neighborhood> neighborhoodList);
}
