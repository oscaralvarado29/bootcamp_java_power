package com.rutas.route.infraestructure.output.feing.adapter;

import com.rutas.route.domain.model.Neighborhood;
import com.rutas.route.domain.spi.INeighborhoodPersistancePort;
import com.rutas.route.infraestructure.output.client.NeigborhoodClient;
import com.rutas.route.infraestructure.output.feing.entity.NeighborhoodRequest;
import com.rutas.route.infraestructure.output.feing.mapper.NeighborhoodRequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RequiredArgsConstructor
public class NeighborhoodFeingAdapter implements INeighborhoodPersistancePort {

    private final NeigborhoodClient neigborhoodClient;
    private final NeighborhoodRequestMapper neighborhoodRequestMapper;
    @Override

    public Neighborhood getNeighborhood(Long neighborhoodId) {
        Neighborhood neighborhood = neighborhoodRequestMapper.toNeighborhood(neigborhoodClient.getNeighborhoodByIdFromDB(neighborhoodId).getBody());
        return neighborhood;
    }

    @Override
    public List<Neighborhood> getAllNeighborhoods() {
        return neighborhoodRequestMapper.toNeighborhoodList(neigborhoodClient.getAllNeighborhoodsFromDB().getBody());
    }

}
