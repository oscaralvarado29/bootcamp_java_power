package com.rutas.route.application.mapper;

import com.rutas.route.application.dto.NeighborhoodResponse;
import com.rutas.route.domain.model.Neighborhood;
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

