package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.dto.CityDto;
import com.airlines.yourairlines.entity.City;
import com.airlines.yourairlines.mapper.CityMapper;
import com.airlines.yourairlines.mapper.EntityMapper;
import com.airlines.yourairlines.service.ICityService;
import com.airlines.yourairlines.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class CityController extends CrudController<City, CityDto> {
  @Autowired private ICityService cityService;
  @Autowired private CityMapper cityMapper;

  @Override
  public ICrudService<City> getService() {
    return cityService;
  }

  @Override
  public EntityMapper<City, CityDto> getMapper() {
    return cityMapper;
  }
}
