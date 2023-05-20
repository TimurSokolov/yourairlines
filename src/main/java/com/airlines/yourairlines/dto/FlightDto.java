package com.airlines.yourairlines.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FlightDto extends VersionedDto {
    private Long departureAirportId;
    private LocalDateTime arrivalTime;
    private Long arrivalAirportId;
    private Long reservedPlaneId;
    private LocalDateTime departureTime;
}
