package com.airlines.yourairlines.service;

import com.airlines.yourairlines.entity.Airport;
import com.airlines.yourairlines.exception.NotFoundException;
import com.airlines.yourairlines.repository.IAirportRepository;
import com.airlines.yourairlines.repository.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirportService extends CrudService<Airport> implements IAirportService {
    @Autowired
    private IAirportRepository airportRepository;
    @Autowired
    ICityService cityService;

    @Override
    public IBaseRepository<Airport> getRepository() {
        return airportRepository;
    }

    @Override
    protected void validate(Airport entity) {
    }

    public Airport findById(Long id) {
        Optional<Airport> airportOptional = airportRepository.findById(id);
        return airportOptional.orElseThrow(() -> new NotFoundException("Аэропорт с id = " + id + " не найден"));
    }

    @Override
    public Airport save(Airport airport) {
        try {
            cityService.get(airport.getCityId());
        } catch (NotFoundException e) {
            throw new NotFoundException(String.format("Города с id = %s не существует", airport.getCityId()));
        }
        return airportRepository.save(airport);
    }

    public String getAirportNameById(Long id) {
        Optional<Airport> airportOpt = airportRepository.findById(id);
        Airport airport = airportOpt.orElseThrow(() -> new NotFoundException("Аэропорт с id = " + id + " не найден"));
        return airport.getName();
    }
}
