package com.airlines.yourairlines.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Airport extends VersionedEntity {

    private String name;
    private String timezone;
    private String lat;
    private String lon;
    private Long cityId;

    @OneToMany(mappedBy = "departureAirportId")
    private List<Flight> departureFlights = new ArrayList<>();

    @OneToMany(mappedBy = "arrivalAirportId")
    private List<Flight> arrivalFlights = new ArrayList<>();


}
