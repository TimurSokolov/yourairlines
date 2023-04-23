package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.dto.FlightDto;
import com.airlines.yourairlines.entity.Airport;
import com.airlines.yourairlines.entity.Flight;
import com.airlines.yourairlines.entity.Plane;
import com.airlines.yourairlines.mapper.EntityMapper;
import com.airlines.yourairlines.mapper.FlightMapper;
import com.airlines.yourairlines.service.IAirportService;
import com.airlines.yourairlines.service.ICrudService;
import com.airlines.yourairlines.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController extends CrudController<Flight, FlightDto> {
    @Autowired
    private IFlightService flightService;
    @Autowired
    private FlightMapper flightMapper;
    @Autowired
    private IAirportService airportService;

    @Override
    public ICrudService<Flight> getService() {
        return flightService;
    }

    @Override
    public EntityMapper<Flight, FlightDto> getMapper() {
        return flightMapper;
    }

    @GetMapping("/searchSuitablePlanes")
    public List<Plane> searchSuitablePlanes(@RequestParam Long departureAirportId, Long arrivalAirportId, LocalDateTime departureTime) {
        Airport departureAirport = airportService.get(departureAirportId);
        Airport arrivalAirport = airportService.get(arrivalAirportId);
        return flightService.getSuitablePlanes(departureAirport, arrivalAirport, departureTime);
    }

}
