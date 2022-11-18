package com.rutas.route.infraestructure.output.jpa.mapper;

import com.rutas.route.domain.model.Travel;
import com.rutas.route.infraestructure.output.jpa.entity.TravelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TravelEntityMapper {
    TravelEntity toTravelEntity(Travel travel);
    Travel toTravel(TravelEntity travelEntity);
    List<Travel> toTravelList(List<TravelEntity> travelEntityList);
}
