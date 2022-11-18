package com.rutas.neighborhoodTraveler.domain.model;

public class NeighborhoodTraveler {

    private String neighborhoodName;
    private String neighborhoodDescription;

    public NeighborhoodTraveler(String neighborhoodName, String neighborhoodDescription) {
        this.neighborhoodName = neighborhoodName;
        this.neighborhoodDescription = neighborhoodDescription;
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
