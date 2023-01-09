package com.airlines.yourairlines.repository;

import com.airlines.yourairlines.dto.Plane;
import org.springframework.stereotype.Repository;

@Repository
public class PlaneRepository extends CrudRepository<Plane> implements IPlaneRepository {

}
