package com.rutas.neighborhoodTraveler.infraestructure.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NeighborhoodRequest {

    private Long neighborhoodId;
    private String neighborhoodName;
    private String neighborhoodDescription;
}
