package com.rutas.conductor.creacion_de_rutas.applicaton.mapper;

import com.rutas.conductor.creacion_de_rutas.applicaton.dto.TravelDto;
import com.rutas.conductor.creacion_de_rutas.domain.model.Travel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TravelDtoMapper {
    TravelDto toDateDto(Travel travel);
    List<TravelDto> toDateDtoList(List<Travel> travels);
}
