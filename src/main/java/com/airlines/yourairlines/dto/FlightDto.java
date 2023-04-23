package com.airlines.yourairlines.dto;

import com.airlines.yourairlines.entity.Airport;
import com.airlines.yourairlines.entity.Plane;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FlightDto extends VersionedDto {
    private Airport departureAirport;
    private LocalDateTime arrivalTime;
    private Airport arrivalAirport;
    private Plane reservedPlane;
    private LocalDateTime departureTime;
}
