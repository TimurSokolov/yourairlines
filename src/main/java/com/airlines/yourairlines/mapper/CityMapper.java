package com.airlines.yourairlines.mapper;

import com.airlines.yourairlines.dto.CityDto;
import com.airlines.yourairlines.entity.City;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CityMapper implements EntityMapper<City, CityDto> {
  @Override
  public abstract City mapToEntity(CityDto dto);

  @Override
  public abstract CityDto mapToDto(City entity);
}
