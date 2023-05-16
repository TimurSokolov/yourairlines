package com.airlines.yourairlines.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Flight extends VersionedEntity {

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Long departureAirportId;
    private Long arrivalAirportId;
    private Long reservedPlaneId;
}
