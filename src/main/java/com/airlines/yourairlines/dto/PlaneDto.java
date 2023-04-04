package com.airlines.yourairlines.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaneDto extends VersionedDto {
    private String sideNumber;
    private String brand;
    private String model;
    private Integer maxFlightRange;
    private Integer maxNumberOfPeople;
    private Integer fuelConsumption;
}
