package com.airlines.yourairlines.repository;

import com.airlines.yourairlines.dto.City;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CityRepository extends CrudRepository<City> implements ICityRepository {

    public CityRepository() {
        super(City.class);
    }

    @Override
    RowMapper<City> getMapper() {
        return null;
    }

    @Override
    PreparedStatementCreator getPreparedStatementCreator(City dtoToSave) {
        return null;
    }

}
