package com.airlines.yourairlines.dto;

import com.airlines.yourairlines.entity.Flight;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AirportDto extends VersionedDto {
    private Long cityId;
    private String name;
    private String timezone;
    private String lat;
    private String lon;
    private List<Flight> departureFlights = new ArrayList<>();
    private List<Flight> arrivalFlights = new ArrayList<>();
}
