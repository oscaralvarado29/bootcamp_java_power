package com.rutas.route.application.mapper;

import com.rutas.route.application.dto.TravelDto;
import com.rutas.route.domain.model.Travel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TravelDtoMapper {
    TravelDto toTravelDto(Travel travel);
    List<TravelDto> toTravelDtoList(List<Travel> travels);
}

