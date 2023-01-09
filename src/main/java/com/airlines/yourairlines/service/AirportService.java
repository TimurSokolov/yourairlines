package com.airlines.yourairlines.service;

import com.airlines.yourairlines.dto.Airport;
import com.airlines.yourairlines.repository.IAirportRepository;
import com.airlines.yourairlines.repository.ICrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportService extends CrudService<Airport> implements IAirportService{
    @Autowired
    private IAirportRepository airportRepository;
    @Override
    public ICrudRepository<Airport> getRepository() {
        return airportRepository;
    }

    @Override
    protected void validate(Airport dto) {

    }
}
