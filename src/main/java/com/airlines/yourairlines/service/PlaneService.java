package com.airlines.yourairlines.service;

import com.airlines.yourairlines.entity.Plane;
import com.airlines.yourairlines.repository.IBaseRepository;
import com.airlines.yourairlines.repository.IFlightRepository;
import com.airlines.yourairlines.repository.IPlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PlaneService extends CrudService<Plane> implements IPlaneService {
    @Autowired
    private IPlaneRepository planeRepository;
    @Autowired
    private DayChangeService dayChangeService;
    @Autowired
    private IFlightRepository flightRepository;

    @Override
    public IBaseRepository<Plane> getRepository() {
        return planeRepository;
    }

    @Override
    protected void validate(Plane entity) {
        if (entity.getEndOfReserveTime() == null) {
            entity.setEndOfReserveTime(LocalDateTime.of(2023, 1, 1, 0, 0));
        }

    }
}
