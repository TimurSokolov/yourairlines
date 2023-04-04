package com.airlines.yourairlines.service;

import com.airlines.yourairlines.dto.PlaneDto;
import com.airlines.yourairlines.entity.Plane;
import com.airlines.yourairlines.repository.IBaseRepository;
import com.airlines.yourairlines.repository.IPlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaneService extends CrudService<Plane> implements IPlaneService {
    @Autowired
    private IPlaneRepository planeRepository;

    @Override
    public IBaseRepository<Plane> getRepository() {
        return planeRepository;
    }

    @Override
    protected void validate(Plane entity) {

    }
}
