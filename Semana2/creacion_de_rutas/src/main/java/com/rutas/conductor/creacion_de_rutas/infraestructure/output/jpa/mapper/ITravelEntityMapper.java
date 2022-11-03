package com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.mapper;

import com.rutas.conductor.creacion_de_rutas.domain.model.Travel;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.entity.TravelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ITravelEntityMapper {

    TravelEntity toTravelEntity(Travel travel);
    Travel toTravel(TravelEntity travelEntity);
    List<Travel> toTravelList(List<TravelEntity> travelEntityList);
    List<TravelEntity> toTravelEntityList(List<Travel> travelList);
}
