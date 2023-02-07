package com.airlines.yourairlines.repository;

import com.airlines.yourairlines.dto.Plane;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PlaneRepository extends CrudRepository<Plane> implements IPlaneRepository {

    public PlaneRepository() {
        super(Plane.class);
    }

    @Override
    RowMapper<Plane> getMapper() {
        return null;
    }

    @Override
    PreparedStatementCreator getPreparedStatementCreator(Plane dtoToSave) {
        return null;
    }

}
