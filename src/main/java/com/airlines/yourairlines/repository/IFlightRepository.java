package com.airlines.yourairlines.repository;

import com.airlines.yourairlines.entity.Flight;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Repository
public interface IFlightRepository extends IBaseRepository<Flight> {
    ArrayList<Flight> findByReservedPlaneId(Long reservedPlaneId);

    ArrayList<Flight> findByDepartureTimeAfterAndDepartureTimeBefore(LocalDateTime startTimeOfSync, LocalDateTime endTimeOfSync);

    ArrayList<Flight> findByArrivalTimeAfterAndArrivalTimeBefore(LocalDateTime startTimeOfSync, LocalDateTime endTimeOfSync);

}
