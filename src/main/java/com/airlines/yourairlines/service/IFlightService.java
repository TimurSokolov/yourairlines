package com.airlines.yourairlines.service;

import com.airlines.yourairlines.entity.Flight;
import com.airlines.yourairlines.entity.Plane;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface IFlightService extends ICrudService<Flight> {
    ArrayList<Plane> getSuitablePlanes(Long departureAirportId, Long arrivalAirportId, LocalDateTime departureTime);

    LocalDateTime calcLastReservedArrivalTime(Plane plane);

}
