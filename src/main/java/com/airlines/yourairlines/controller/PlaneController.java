package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.dto.PlaneDto;
import com.airlines.yourairlines.entity.Plane;
import com.airlines.yourairlines.mapper.EntityMapper;
import com.airlines.yourairlines.mapper.PlaneMapper;
import com.airlines.yourairlines.service.ICrudService;
import com.airlines.yourairlines.service.IPlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plane")
public class PlaneController extends CrudController<Plane, PlaneDto> {
    @Autowired
    private IPlaneService planeService;
    @Autowired
    private PlaneMapper planeMapper;

    @Override
    public ICrudService<Plane> getService() {
        return planeService;
    }

    @Override
    public EntityMapper getMapper() {
        return planeMapper;
    }
}
