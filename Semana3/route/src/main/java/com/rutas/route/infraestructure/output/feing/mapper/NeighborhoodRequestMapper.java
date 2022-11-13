package com.rutas.route.infraestructure.output.feing.mapper;

import com.rutas.route.domain.model.Neighborhood;
import com.rutas.route.infraestructure.output.feing.entity.NeighborhoodRequest;

import java.util.List;

public interface NeighborhoodRequestMapper {
    Neighborhood toNeighborhood(NeighborhoodRequest neighborhoodRequest);
    List<Neighborhood> toNeighborhoodList(List<NeighborhoodRequest> neighborhoodRequestList);
}
