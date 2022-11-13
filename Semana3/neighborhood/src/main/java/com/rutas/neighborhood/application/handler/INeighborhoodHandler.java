package com.rutas.neighborhood.application.handler;

import com.rutas.neighborhood.application.dto.NeighborhoodRequest;
import com.rutas.neighborhood.application.dto.NeighborhoodResponse;

import java.util.List;

public interface INeighborhoodHandler {
    void saveNeighborhoodInDB(NeighborhoodRequest neighborhoodRequest);
    List<NeighborhoodResponse> getAllNeighborhoodsFromDB();
    NeighborhoodResponse getNeighborhoodFromDBByName(String name);
    void deleteNeighborhoodInDB(String name);
    void updateNeighborhoodInDB(NeighborhoodRequest neighborhoodRequest);
}
