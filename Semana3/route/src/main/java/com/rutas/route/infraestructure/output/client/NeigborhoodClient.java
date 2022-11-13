package com.rutas.route.infraestructure.output.client;

import com.rutas.route.infraestructure.output.feing.entity.NeighborhoodRequest;
import com.rutas.route.infraestructure.output.client.configuration.NeigborhoodClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "NeigborhoodClient",configuration = NeigborhoodClientConfiguration.class, url = "http://localhost:8093/neigborhood")
public interface NeigborhoodClient {
    @GetMapping("/{id}")
    public ResponseEntity<NeighborhoodRequest> getNeighborhoodByIdFromDB(@PathVariable(name = "id") Long neighborhoodId);

    @GetMapping("/getAll")
    ResponseEntity<List<NeighborhoodRequest>> getAllNeighborhoodsFromDB();
}
