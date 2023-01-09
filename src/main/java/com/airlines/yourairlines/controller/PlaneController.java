package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.dto.Plane;
import com.airlines.yourairlines.service.ICrudService;
import com.airlines.yourairlines.service.IPlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plane")
public class PlaneController extends CrudController<Plane>{
    @Autowired
    private IPlaneService planeService;

    @Override
    public ICrudService<Plane> getService() {
        return planeService;
    }
}
