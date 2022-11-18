package com.rutas.route.application.handler;

import com.rutas.route.application.dto.NeighborhoodRequest;
import com.rutas.route.application.dto.NeighborhoodResponse;

import java.util.List;

public interface INeighborhoodHandler {
    void saveNeighborhoodInDB(NeighborhoodRequest neighborhoodRequest);
    List<NeighborhoodResponse> getAllNeighborhoodsFromDB();
    NeighborhoodResponse getNeighborhoodFromDBByName(String name);
    void deleteNeighborhoodInDB(String name);
    void updateNeighborhoodInDB(NeighborhoodRequest neighborhoodRequest);
}
