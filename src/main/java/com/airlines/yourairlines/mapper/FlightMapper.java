package com.airlines.yourairlines.mapper;

import com.airlines.yourairlines.dto.FlightDto;
import com.airlines.yourairlines.entity.Flight;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class FlightMapper implements EntityMapper<Flight, FlightDto> {
  @Override
  public abstract Flight mapToEntity(FlightDto dto);

  @Override
  public abstract FlightDto mapToDto(Flight entity);
}
