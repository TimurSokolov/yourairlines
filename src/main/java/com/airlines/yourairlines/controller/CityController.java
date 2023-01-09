package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.dto.City;
import com.airlines.yourairlines.service.ICityService;
import com.airlines.yourairlines.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class CityController extends CrudController<City>{
    @Autowired
    private ICityService cityService;

    @Override
    public ICrudService<City> getService() {
        return cityService;
    }
}
