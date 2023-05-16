package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.dto.CoordinatesDto;
import com.airlines.yourairlines.service.IMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/map")
public class MapController {
    @Autowired
    private IMapService mapService;

    @GetMapping("/getcoordinates/{address}")
    public CoordinatesDto getCoordinates(@PathVariable String address) {
        return mapService.geoCoding(address);
    }

    @GetMapping("/getaddress")
    public String getAddress(@RequestParam String lat, String lon) {
        return mapService.geoDecoding(lat, lon);
    }

    @GetMapping("/getdistance")
    public Double getDistance(@RequestParam String departureAddress, String arrivalAddress) {
        return mapService.calcDistanceBetweenPoints(departureAddress, arrivalAddress);
    }


}
