package com.rutas.route.infraestructure.output.jpa.mapper;

import com.rutas.route.domain.model.Travel;
import com.rutas.route.infraestructure.output.jpa.entity.TravelEntity;

import java.util.List;

public interface TravelEntityMapper {
    TravelEntity toTravelEntity(Travel travel);
    Travel toTravel(TravelEntity travelEntity);
    List<Travel> toTravelList(List<TravelEntity> travelEntityList);
}
