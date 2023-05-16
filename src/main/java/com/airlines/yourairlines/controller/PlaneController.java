package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.dto.PlaneDto;
import com.airlines.yourairlines.dto.valiation.Create;
import com.airlines.yourairlines.entity.Flight;
import com.airlines.yourairlines.entity.Plane;
import com.airlines.yourairlines.mapper.EntityMapper;
import com.airlines.yourairlines.mapper.PlaneMapper;
import com.airlines.yourairlines.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plane")
public class PlaneController extends CrudController<Plane, PlaneDto> {
    @Autowired
    private IPlaneService planeService;
    @Autowired
    private PlaneMapper planeMapper;
    @Autowired
    private IFlightService flightService;
    @Autowired
    private DayChangeService dayChangeService;
    @Autowired
    private AirportService airportService;

    @Override
    public ICrudService<Plane> getService() {
        return planeService;
    }

    @Override
    public EntityMapper getMapper() {
        return planeMapper;
    }

    @Override
    @PostMapping
    public PlaneDto save(@RequestBody @Validated(Create.class) PlaneDto dtoToSave) { //todo убрать в сервисы
        Plane entity = planeMapper.mapToEntity(dtoToSave);
        Flight flight = new Flight();
        entity = planeService.save(entity);
        flight.setDepartureTime(dayChangeService.getCurrentDate());
        flight.setArrivalTime(dayChangeService.getCurrentDate());
        flight.setDepartureAirportId(dtoToSave.getStartAirportId());
        flight.setArrivalAirportId(dtoToSave.getStartAirportId());
        flight.setReservedPlaneId(entity.getId());
        flightService.save(flight);

        return planeMapper.mapToDto(entity);
    }
}
