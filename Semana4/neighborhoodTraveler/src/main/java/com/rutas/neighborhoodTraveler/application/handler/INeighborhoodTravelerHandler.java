package com.rutas.neighborhoodTraveler.application.handler;

import com.rutas.neighborhoodTraveler.application.dto.NeighborhoodTravelerResponse;
import com.rutas.neighborhoodTraveler.domain.model.NeighborhoodTraveler;

import java.util.List;

public interface INeighborhoodTravelerHandler {

    List<NeighborhoodTravelerResponse> getAllNeighborhoods();
}
