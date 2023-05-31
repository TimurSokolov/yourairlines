package com.airlines.yourairlines.mapper;

import com.airlines.yourairlines.dto.AirportDto;
import com.airlines.yourairlines.entity.Airport;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class AirportMapper implements EntityMapper<Airport, AirportDto> {
  @Override
  public abstract Airport mapToEntity(AirportDto dto);

  @Override
  public abstract AirportDto mapToDto(Airport entity);
}
