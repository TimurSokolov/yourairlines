package com.airlines.yourairlines.repository;

import com.airlines.yourairlines.entity.Flight;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IFlightRepository extends IBaseRepository<Flight> {
  ArrayList<Flight> findByReservedPlaneId(Long reservedPlaneId);

  ArrayList<Flight> findByDepartureTimeAfterAndDepartureTimeBefore(
      LocalDateTime startTimeOfSync, LocalDateTime endTimeOfSync);

  ArrayList<Flight> findByArrivalTimeAfterAndArrivalTimeBefore(
      LocalDateTime startTimeOfSync, LocalDateTime endTimeOfSync);

  @Query(
      value =
          "SELECT DISTINCT ON(arrival_time) * FROM flight "
              + "where reserved_plane_id = :plane "
              + "ORDER BY arrival_time DESC "
              + "LIMIT 1",
      nativeQuery = true)
  Flight findLastReservedFlight(@Param("plane") Long planeId);
}
