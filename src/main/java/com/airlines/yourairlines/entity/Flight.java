package com.airlines.yourairlines.entity;

import jakarta.persistence.Entity;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

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
