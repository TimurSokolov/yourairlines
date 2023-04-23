package com.airlines.yourairlines.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Flight extends VersionedEntity {

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "departureAirport_id", nullable = false)
    @JsonIgnore
    private Airport departureAirport;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "arrivalAirport_id", nullable = false)
    @JsonIgnore
    private Airport arrivalAirport;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "reservedPlane_id", nullable = false)
    @JsonIgnore
    private Plane reservedPlane;
}
