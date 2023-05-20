package com.airlines.yourairlines.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Plane extends VersionedEntity {
    private String sideNumber;
    private String brand;
    private String model;
    private Integer maxFlightRange;
    private Integer maxNumberOfPeople;
    private Integer fuelConsumption;
    private Integer cruiseSpeed;
    private LocalDateTime endOfReserveTime;
}
