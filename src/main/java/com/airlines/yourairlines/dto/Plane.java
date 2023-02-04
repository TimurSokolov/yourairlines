package com.airlines.yourairlines.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Plane extends LongIdDto {
    private String sideNumber;
    private String brand;
    private String model;
    private Coordinates planeCoordinates;
    private PlaneState planeState;
}
