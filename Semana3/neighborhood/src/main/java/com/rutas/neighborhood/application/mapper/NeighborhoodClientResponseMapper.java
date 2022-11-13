package com.rutas.neighborhood.application.mapper;

import com.rutas.neighborhood.application.dto.NeighborhoodClientResponse;
import com.rutas.neighborhood.domain.model.Neighborhood;

public interface NeighborhoodClientResponseMapper {
    NeighborhoodClientResponse toNeighborhoodClientResponse(Neighborhood neighborhood);
}
