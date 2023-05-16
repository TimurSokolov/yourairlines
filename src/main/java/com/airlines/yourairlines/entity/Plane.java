package com.airlines.yourairlines.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "reservedPlaneId")
    private List<Flight> reservedFlights = new ArrayList<>();

    private LocalDateTime endOfReserveTime;
}
