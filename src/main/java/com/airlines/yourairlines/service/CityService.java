package com.airlines.yourairlines.service;

import com.airlines.yourairlines.entity.City;
import com.airlines.yourairlines.repository.IBaseRepository;
import com.airlines.yourairlines.repository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService extends CrudService<City> implements ICityService {
    @Autowired
    private ICityRepository cityRepository;

    @Override
    public IBaseRepository<City> getRepository() {
        return cityRepository;
    }

    @Override
    protected void validate(City entity) {
    }

}
