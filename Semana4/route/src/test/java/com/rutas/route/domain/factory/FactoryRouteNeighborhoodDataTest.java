package com.rutas.route.domain.factory;

import com.rutas.route.domain.model.RouteNeighborhood;

import java.util.ArrayList;
import java.util.List;

public class FactoryRouteNeighborhoodDataTest {
    public static RouteNeighborhood getRouteNeighborhood() {
        RouteNeighborhood routeNeighborhood = new RouteNeighborhood();
        routeNeighborhood.setRouteNeighborhoodId(1L);
        routeNeighborhood.setRouteId(1L);
        routeNeighborhood.setNeighborhoodId(1L);
        routeNeighborhood.setMeetingPoint("Calle 1");
        routeNeighborhood.setPosition(1);
        return routeNeighborhood;
    }

    public static List<RouteNeighborhood> getRouteNeighborhoodsList() {
        List<RouteNeighborhood> routeNeighborhoods = new ArrayList<>();
        routeNeighborhoods.add(getRouteNeighborhood());
        routeNeighborhoods.add(new RouteNeighborhood(2L, 1L, 2L, "Calle 2", 2));
        return routeNeighborhoods;
    }
}
