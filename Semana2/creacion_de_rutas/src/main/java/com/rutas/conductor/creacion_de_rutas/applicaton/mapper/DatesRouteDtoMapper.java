package com.rutas.conductor.creacion_de_rutas.applicaton.mapper;

import com.rutas.conductor.creacion_de_rutas.applicaton.dto.DatesRouteDto;
import com.rutas.conductor.creacion_de_rutas.domain.model.DatesRoute;

import java.util.List;

public interface DatesRouteDtoMapper {
    DatesRouteDto toDateDto(DatesRoute datesRoute);
    List<DatesRouteDto> toDateDtoList(List<DatesRoute> datesRoutes);
}
