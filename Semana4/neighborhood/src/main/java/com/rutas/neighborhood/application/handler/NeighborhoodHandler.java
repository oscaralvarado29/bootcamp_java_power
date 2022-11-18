package com.rutas.neighborhood.application.handler;


import com.rutas.neighborhood.application.dto.NeighborhoodClientResponse;
import com.rutas.neighborhood.application.dto.NeighborhoodRequest;
import com.rutas.neighborhood.application.dto.NeighborhoodResponse;
import com.rutas.neighborhood.application.mapper.NeighborhoodClientResponseMapper;
import com.rutas.neighborhood.application.mapper.NeighborhoodRequestMapper;
import com.rutas.neighborhood.application.mapper.NeighborhoodResponseMapper;
import com.rutas.neighborhood.domain.api.INeighborhoodServicePort;
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
    private final NeighborhoodClientResponseMapper neighborhoodClientResponseMapper;


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
    public List<NeighborhoodClientResponse> getNeighborhoodFromDBByNameForClient() {
        return neighborhoodClientResponseMapper.toNeighborhoodClientResponseList(neighborhoodServicePort.getAllNeighborhoods());
    }

    @Override
    public NeighborhoodClientResponse getNeighborhoodFromDBById(Long neighborhoodId) {
        return neighborhoodClientResponseMapper.toNeighborhoodClientResponse(neighborhoodServicePort.getNeighborhood(neighborhoodId));
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

