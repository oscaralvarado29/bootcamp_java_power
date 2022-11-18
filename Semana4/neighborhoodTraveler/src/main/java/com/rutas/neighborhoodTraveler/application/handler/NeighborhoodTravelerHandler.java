package com.rutas.neighborhoodTraveler.application.handler;

import com.rutas.neighborhoodTraveler.application.dto.NeighborhoodTravelerResponse;
import com.rutas.neighborhoodTraveler.application.mapper.NeighborhoodTravelerMapper;
import com.rutas.neighborhoodTraveler.domain.api.NeighborhoodTravelerServicePort;
import com.rutas.neighborhoodTraveler.domain.model.NeighborhoodTraveler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class NeighborhoodTravelerHandler implements INeighborhoodTravelerHandler {

    private final NeighborhoodTravelerServicePort neighborhoodTravelerServicePort;
    private final NeighborhoodTravelerMapper neighborhoodTravelerMapper;


    @Override
    public List<NeighborhoodTravelerResponse> getAllNeighborhoods() {
        return neighborhoodTravelerMapper.toNeighborhoodTravelerResponse(neighborhoodTravelerServicePort.getAllNeighborhoods());
    }

}
