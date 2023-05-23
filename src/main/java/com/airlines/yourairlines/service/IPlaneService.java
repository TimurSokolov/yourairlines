package com.airlines.yourairlines.service;

import com.airlines.yourairlines.entity.Plane;
import com.airlines.yourairlines.enums.PlaneState;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface IPlaneService extends ICrudService<Plane> {
    PlaneState getPlaneState(Long planeId);

    String getSideNumberById(Long id);

    ArrayList<Plane> findByMaxFlightRangeGreaterThanEqualAndEndOfReserveTimeBefore(Integer flightDistance, LocalDateTime requiredDateTime);

    Plane findById(Long id);

    Plane save(Plane planeToSave, Long startAirportId);
}
