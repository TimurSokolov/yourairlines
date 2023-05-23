package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.dto.PlaneDto;
import com.airlines.yourairlines.dto.valiation.Create;
import com.airlines.yourairlines.entity.Plane;
import com.airlines.yourairlines.enums.PlaneState;
import com.airlines.yourairlines.mapper.EntityMapper;
import com.airlines.yourairlines.mapper.PlaneMapper;
import com.airlines.yourairlines.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plane")
public class PlaneController extends CrudController<Plane, PlaneDto> {
    @Autowired
    private IPlaneService planeService;
    @Autowired
    private PlaneMapper planeMapper;
    @Autowired
    private IFlightService flightService;
    @Autowired
    private DayChangeService dayChangeService;
    @Autowired
    private IAirportService airportService;

    @Override
    public ICrudService<Plane> getService() {
        return planeService;
    }

    @Override
    public EntityMapper<Plane, PlaneDto> getMapper() {
        return planeMapper;
    }

    @Override
    @PostMapping
    public PlaneDto save(@RequestBody @Validated(Create.class) PlaneDto dtoToSave) {
        Plane entity = planeMapper.mapToEntity(dtoToSave);
        entity = planeService.save(entity, dtoToSave.getStartAirportId());
        return planeMapper.mapToDto(entity);
    }

    @GetMapping("/getplanestate/{id}")
    public PlaneState getCoordinates(@PathVariable Long id) {
        return planeService.getPlaneState(id);
    }
}
