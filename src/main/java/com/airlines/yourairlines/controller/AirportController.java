package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.dto.AirportDto;
import com.airlines.yourairlines.entity.Airport;
import com.airlines.yourairlines.mapper.AirportMapper;
import com.airlines.yourairlines.mapper.EntityMapper;
import com.airlines.yourairlines.service.IAirportService;
import com.airlines.yourairlines.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airport")
public class AirportController extends CrudController<Airport, AirportDto> {
  @Autowired private IAirportService airportService;
  @Autowired private AirportMapper airportMapper;

  @Override
  public ICrudService<Airport> getService() {
    return airportService;
  }

  @Override
  public EntityMapper<Airport, AirportDto> getMapper() {
    return airportMapper;
  }
}
