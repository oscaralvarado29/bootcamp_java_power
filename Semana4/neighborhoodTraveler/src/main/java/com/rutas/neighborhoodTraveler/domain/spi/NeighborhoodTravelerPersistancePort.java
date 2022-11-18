package com.rutas.neighborhoodTraveler.domain.spi;

import com.rutas.neighborhoodTraveler.domain.model.NeighborhoodTraveler;

import java.util.List;

public interface NeighborhoodTravelerPersistancePort {

    List<NeighborhoodTraveler> getAllNeighborhoods();
}
