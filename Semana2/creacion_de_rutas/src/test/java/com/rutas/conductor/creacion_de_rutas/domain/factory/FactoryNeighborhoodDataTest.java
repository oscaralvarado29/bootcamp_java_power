package com.rutas.conductor.creacion_de_rutas.domain.factory;

import com.rutas.conductor.creacion_de_rutas.domain.model.Neighborhood;

public class FactoryNeighborhoodDataTest {
    public static Neighborhood getNeighborhood() {
        Neighborhood neighborhood = new Neighborhood();
        neighborhood.setNeighborhoodName("Neighborhood 1");
        neighborhood.setNeighborhoodDescription("Neighborhood 1 description");
        return neighborhood;
    }
}
