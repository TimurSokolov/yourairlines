package com.airlines.yourairlines.service;

import com.airlines.yourairlines.entity.Airport;

public interface IAirportService extends ICrudService<Airport> {
  Airport findById(Long id);

  String getAirportNameById(Long id);
}
