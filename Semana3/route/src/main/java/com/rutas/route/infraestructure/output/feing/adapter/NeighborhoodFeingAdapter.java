package com.rutas.route.infraestructure.output.feing.adapter;

import com.rutas.route.domain.model.Neighborhood;
import com.rutas.route.domain.spi.INeighborhoodPersistancePort;
import com.rutas.route.infraestructure.output.client.NeigborhoodClient;
import com.rutas.route.infraestructure.output.feing.mapper.NeighborhoodRequestMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class NeighborhoodFeingAdapter implements INeighborhoodPersistancePort {

    private final NeigborhoodClient neigborhoodClient;
    private final NeighborhoodRequestMapper neighborhoodRequestMapper;
    @Override
    public Neighborhood getNeighborhood(Long neighborhoodId) {
        return neighborhoodRequestMapper.toNeighborhood(neigborhoodClient.getNeighborhoodByIdFromDB(neighborhoodId).getBody());
    }

    @Override
    public List<Neighborhood> getAllNeighborhoods() {
        return neighborhoodRequestMapper.toNeighborhoodList(neigborhoodClient.getAllNeighborhoodsFromDB().getBody());
    }
}
