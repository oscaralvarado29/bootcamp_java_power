package com.rutas.route.infraestructure.output.client;

import com.rutas.route.infraestructure.output.feing.entity.NeighborhoodRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "NeigborhoodClient", url = "http://localhost:8092/neighborhood")
public interface NeigborhoodClient {
    @GetMapping("/{id}")
    public ResponseEntity<NeighborhoodRequest> getNeighborhoodByIdFromDB(@PathVariable(name = "id") Long neighborhoodId);

    @GetMapping("/getAllForClient")
    ResponseEntity<List<NeighborhoodRequest>> getAllNeighborhoodsFromDB();
}
