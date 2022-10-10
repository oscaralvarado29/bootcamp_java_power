package com.rutas.conductor.creacion_de_rutas.applicaton.mapper;

import com.rutas.conductor.creacion_de_rutas.applicaton.dto.TravelDto;
import com.rutas.conductor.creacion_de_rutas.domain.model.Travel;

import java.util.List;

public interface TravelDtoMapper {
    TravelDto toDateDto(Travel travel);
    List<TravelDto> toDateDtoList(List<Travel> travels);
}
