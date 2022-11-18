package com.rutas.neighborhoodTraveler.application.mapper;

import com.rutas.neighborhoodTraveler.application.dto.NeighborhoodTravelerResponse;
import com.rutas.neighborhoodTraveler.domain.model.NeighborhoodTraveler;

import java.util.List;

public interface NeighborhoodTravelerMapper {
    List<NeighborhoodTravelerResponse> toNeighborhoodTravelerResponse(List<NeighborhoodTraveler> neighborhoodTraveler);
}
