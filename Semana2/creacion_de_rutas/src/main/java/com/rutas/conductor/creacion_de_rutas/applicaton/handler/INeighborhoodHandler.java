package com.rutas.conductor.creacion_de_rutas.applicaton.handler;

import com.rutas.conductor.creacion_de_rutas.applicaton.dto.NeighborhoodRequest;
import com.rutas.conductor.creacion_de_rutas.applicaton.dto.NeighborhoodResponse;

import java.util.List;

public interface INeighborhoodHandler {
    void saveNeighborhoodInDB(NeighborhoodRequest neighborhoodRequest);
    List<NeighborhoodResponse> getAllNeighborhoodsFromDB();
    NeighborhoodResponse getNeighborhoodFromDB(Long id);
    NeighborhoodResponse getNeighborhoodFromDBByName(String name);
    void deleteNeighborhoodInDB(String name);
    void updateNeighborhoodInDB(NeighborhoodRequest neighborhoodRequest);
}
