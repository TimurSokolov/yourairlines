package com.airlines.yourairlines.repository;

import com.airlines.yourairlines.dto.Airport;
import org.springframework.stereotype.Repository;

@Repository
public class AirportRepository extends CrudRepository<Airport> implements IAirportRepository{
}
