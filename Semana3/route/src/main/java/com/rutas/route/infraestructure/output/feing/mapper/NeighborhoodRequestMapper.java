package com.rutas.route.infraestructure.output.feing.mapper;

import com.rutas.route.domain.model.Neighborhood;
import com.rutas.route.infraestructure.output.feing.entity.NeighborhoodRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface NeighborhoodRequestMapper {
    Neighborhood toNeighborhood(NeighborhoodRequest neighborhoodRequest);
    List<Neighborhood> toNeighborhoodList(List<NeighborhoodRequest> neighborhoodRequestList);
}
