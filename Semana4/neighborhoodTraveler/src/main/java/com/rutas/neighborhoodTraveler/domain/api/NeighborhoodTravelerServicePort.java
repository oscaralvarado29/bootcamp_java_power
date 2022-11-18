package com.rutas.neighborhoodTraveler.domain.api;

import com.rutas.neighborhoodTraveler.domain.model.NeighborhoodTraveler;

import java.util.List;

public interface NeighborhoodTravelerServicePort {

    List<NeighborhoodTraveler> getAllNeighborhoods();
}
