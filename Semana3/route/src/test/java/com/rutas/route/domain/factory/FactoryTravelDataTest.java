package com.rutas.route.domain.factory;

import com.rutas.route.domain.model.Travel;

import java.util.ArrayList;
import java.util.List;

public class FactoryTravelDataTest {
    public static Travel getTravel() {
        Travel travel = new Travel();
        travel.setTravelId(1L);
        travel.setRouteId(1L);
        travel.setDate("18/12/2022");
        travel.setHour("7:02 am");
        return travel;
    }

    public static List<Travel> getTravelList() {
        List<Travel> travelList = new ArrayList<>();
        travelList.add(getTravel());
        travelList.add(new Travel(2L, 1L, "18/12/2022", "7:02 am"));
        return travelList;
    }
}
