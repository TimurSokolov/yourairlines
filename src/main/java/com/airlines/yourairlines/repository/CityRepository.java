package com.airlines.yourairlines.repository;

import com.airlines.yourairlines.dto.City;
import org.springframework.stereotype.Repository;

@Repository
public class CityRepository extends CrudRepository<City> implements ICityRepository{

}
