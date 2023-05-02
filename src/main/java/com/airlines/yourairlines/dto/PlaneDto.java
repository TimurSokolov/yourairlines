package com.airlines.yourairlines.dto;

import com.airlines.yourairlines.entity.Flight;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private List<Flight> reservedFlights = new ArrayList<>();
    private LocalDateTime endOfReserveTime;
    private Long startAirportId;
}
