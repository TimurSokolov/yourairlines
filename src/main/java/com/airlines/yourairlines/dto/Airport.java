package com.airlines.yourairlines.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Airport extends LongIdDto {
    private City city;
    private String name;
    private Integer timezone;
    private Set<Plane> planeList;
    private Coordinates planeCoordinates;
}
