package com.airlines.yourairlines.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PlaneDto extends VersionedDto {
    private String sideNumber;
    private String brand;
    private String model;
    private Integer maxFlightRange;
    private Integer maxNumberOfPeople;
    private Integer fuelConsumption;
    private Integer cruiseSpeed;
    private LocalDateTime endOfReserveTime;
    private Long startAirportId;
}
