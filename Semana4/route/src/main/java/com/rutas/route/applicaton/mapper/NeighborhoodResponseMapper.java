package com.rutas.route.applicaton.mapper;

import com.rutas.route.applicaton.dto.NeighborhoodResponse;
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

