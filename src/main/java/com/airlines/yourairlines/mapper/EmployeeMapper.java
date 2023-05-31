package com.airlines.yourairlines.mapper;

import com.airlines.yourairlines.dto.EmployeeDto;
import com.airlines.yourairlines.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class EmployeeMapper implements EntityMapper<Employee, EmployeeDto> {
  @Override
  public abstract Employee mapToEntity(EmployeeDto dto);

  @Override
  public abstract EmployeeDto mapToDto(Employee entity);
}
