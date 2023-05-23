package com.airlines.yourairlines.service;

import com.airlines.yourairlines.entity.Airport;

import java.util.Optional;

public interface IAirportService extends ICrudService<Airport> {
    Optional<Airport> findById(Long id);

    String getAirportNameById(Long id);
}
