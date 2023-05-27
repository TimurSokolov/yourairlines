package com.airlines.yourairlines.service;

import com.airlines.yourairlines.entity.Airport;
import com.airlines.yourairlines.entity.Flight;
import com.airlines.yourairlines.entity.Plane;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface IFlightService extends ICrudService<Flight> {


    LocalDateTime calcLastReservedArrivalTime(Plane plane);

    ArrayList<Flight> findByReservedPlaneId(Long reservedPlaneId);

    ArrayList<Flight> findByDepartureTimeAfterAndDepartureTimeBefore(LocalDateTime startTimeOfSync, LocalDateTime endTimeOfSync);

    ArrayList<Flight> findByArrivalTimeAfterAndArrivalTimeBefore(LocalDateTime startTimeOfSync, LocalDateTime endTimeOfSync);

    Integer calcFlightDistance(Airport departureAirport, Airport arrivalAirport);


}
