package com.rutas.route.domain.model;

public class Neighborhood {
    private Long neighborhoodId;
    private String neighborhoodName;
    private String neighborhoodDescription;

    public Neighborhood(){}
    public Neighborhood(Long neighborhoodId, String neighborhoodName, String neighborhoodDescription) {
        this.neighborhoodId = neighborhoodId;
        this.neighborhoodName = neighborhoodName;
        this.neighborhoodDescription = neighborhoodDescription;
    }

    public Long getNeighborhoodId() {
        return neighborhoodId;
    }

    public void setNeighborhoodId(Long neighborhoodId) {
        this.neighborhoodId = neighborhoodId;
    }

    public String getNeighborhoodName() {
        return neighborhoodName;
    }

    public void setNeighborhoodName(String neighborhoodName) {
        this.neighborhoodName = neighborhoodName;
    }

    public String getNeighborhoodDescription() {
        return neighborhoodDescription;
    }

    public void setNeighborhoodDescription(String neighborhoodDescription) {
        this.neighborhoodDescription = neighborhoodDescription;
    }
}
