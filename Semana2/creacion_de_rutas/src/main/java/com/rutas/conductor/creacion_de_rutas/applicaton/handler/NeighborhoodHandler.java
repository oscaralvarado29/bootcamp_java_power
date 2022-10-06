package com.rutas.conductor.creacion_de_rutas.applicaton.handler;

import com.rutas.conductor.creacion_de_rutas.applicaton.dto.NeighborhoodRequest;
import com.rutas.conductor.creacion_de_rutas.applicaton.dto.NeighborhoodResponse;
import com.rutas.conductor.creacion_de_rutas.applicaton.mapper.NeighborhoodRequestMapper;
import com.rutas.conductor.creacion_de_rutas.applicaton.mapper.NeighborhoodResponseMapper;
import com.rutas.conductor.creacion_de_rutas.domain.api.INeighborhoodServicePort;
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
    public NeighborhoodResponse getNeighborhoodFromDB(Long id) {
        return neighborhoodResponseMapper.toNeighborhoodResponse(neighborhoodServicePort.getNeighborhood(id));
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
