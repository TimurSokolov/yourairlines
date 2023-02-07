package com.airlines.yourairlines.service;

import com.airlines.yourairlines.dto.City;
import com.airlines.yourairlines.repository.ICityRepository;
import com.airlines.yourairlines.repository.ICrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService extends CrudService<City> implements ICityService {
    @Autowired
    private ICityRepository cityRepository;

    @Override
    public ICrudRepository<City> getRepository() {
        return cityRepository;
    }

    @Override
    protected void validate(City dto) {

    }
}
