package com.rutas.route.application.handler;


import com.rutas.route.application.dto.NeighborhoodRequest;
import com.rutas.route.application.dto.NeighborhoodResponse;
import com.rutas.route.application.mapper.NeighborhoodRequestMapper;
import com.rutas.route.application.mapper.NeighborhoodResponseMapper;
import com.rutas.route.domain.api.INeighborhoodServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class NeighborhoodHandler implements INeighborhoodHandler{
    private final INeighborhoodServicePort neighborhoodServicePort;
    private final NeighborhoodRequestMapper neighborhoodRequestMapper;
    private final NeighborhoodResponseMapper neighborhoodResponseMapper;


    @Override
    public void saveNeighborhoodInDB(NeighborhoodRequest neighborhoodRequest) {
        neighborhoodServicePort.saveNeighborhood(neighborhoodRequestMapper.toNeighborhood(neighborhoodRequest));
    }

    @Override
    public List<NeighborhoodResponse> getAllNeighborhoodsFromDB() {
        return neighborhoodResponseMapper.toNeighborhoodResponseList(neighborhoodServicePort.getAllNeighborhoods());
    }

    @Override
    public NeighborhoodResponse getNeighborhoodFromDBByName(String name) {
        return neighborhoodResponseMapper.toNeighborhoodResponse(neighborhoodServicePort.findNeighborhoodByName(name));
    }

    @Override
    public void deleteNeighborhoodInDB(String name) {
        neighborhoodServicePort.deleteNeighborhood(name);
    }

    @Override
    public void updateNeighborhoodInDB(NeighborhoodRequest neighborhoodRequest) {
        neighborhoodServicePort.updateNeighborhood(neighborhoodRequestMapper.toNeighborhood(neighborhoodRequest));
    }
}

