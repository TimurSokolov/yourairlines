package com.airlines.yourairlines.mapper;

import com.airlines.yourairlines.dto.PlaneDto;
import com.airlines.yourairlines.entity.Plane;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class PlaneMapper implements EntityMapper<Plane, PlaneDto> {
    @Override
    public abstract Plane mapToEntity(PlaneDto dto);

    @Override
    public abstract PlaneDto mapToDto(Plane entity);
}
