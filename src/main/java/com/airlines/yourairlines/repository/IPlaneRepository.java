package com.airlines.yourairlines.repository;

import com.airlines.yourairlines.entity.Plane;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Repository
public interface IPlaneRepository extends IBaseRepository<Plane> {
    ArrayList<Plane> findByMaxFlightRangeGreaterThanEqualAndEndOfReserveTimeBefore(Integer flightDistance, LocalDateTime requiredDateTime);

}
