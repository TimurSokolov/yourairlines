package com.airlines.yourairlines.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id", nullable = false)
    @JsonIgnore
    private City homeCity;

    @OneToMany(mappedBy = "departureAirport")
    private List<Flight> departureFlights = new ArrayList<>();

    @OneToMany(mappedBy = "arrivalAirport")
    private List<Flight> arrivalFlights = new ArrayList<>();


}
