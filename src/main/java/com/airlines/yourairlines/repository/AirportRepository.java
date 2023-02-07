package com.airlines.yourairlines.repository;

import com.airlines.yourairlines.dto.Airport;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AirportRepository extends CrudRepository<Airport> implements IAirportRepository {
    public AirportRepository() {
        super(Airport.class);
    }

    @Override
    RowMapper<Airport> getMapper() {
        return null;
    }

    @Override
    PreparedStatementCreator getPreparedStatementCreator(Airport dtoToSave) {
        return null;
    }

}
