package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.dto.CoordinatesDto;
import com.airlines.yourairlines.service.IMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/GoogleMap")
public class MapController {
    @Autowired
    private IMapService googleMapService;

    @GetMapping("/getCoordinates/{address}")
    public CoordinatesDto getCoordinates(@PathVariable String address) {
        return googleMapService.geoCoding(address);
    }

    @GetMapping("/getAddress")
    public String getAddress(@RequestParam String lat, String lon) {
        return googleMapService.geoDecoding(lat, lon);
    }

    @GetMapping("/getDistance")
    public Double getDistance(@RequestParam String departureAddress, String arrivalAddress) {
        return googleMapService.calcDistanceBetweenPoints(departureAddress, arrivalAddress);
    }


}
