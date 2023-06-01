package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.dto.FlightDto;
import com.airlines.yourairlines.entity.Flight;
import com.airlines.yourairlines.mapper.EntityMapper;
import com.airlines.yourairlines.mapper.FlightMapper;
import com.airlines.yourairlines.service.ICrudService;
import com.airlines.yourairlines.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flight")
public class FlightController extends CrudController<Flight, FlightDto> {
  @Autowired private IFlightService flightService;
  @Autowired private FlightMapper flightMapper;

  @Override
  public ICrudService<Flight> getService() {
    return flightService;
  }

  @Override
  public EntityMapper<Flight, FlightDto> getMapper() {
    return flightMapper;
  }
}
