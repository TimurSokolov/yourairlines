package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.dto.Airport;
import com.airlines.yourairlines.service.IAirportService;
import com.airlines.yourairlines.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airport")
public class AirportController extends CrudController<Airport> {
    @Autowired
    private IAirportService airportService;

    @Override
    public ICrudService<Airport> getService() {
        return airportService;
    }
}
