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
public class City extends VersionedEntity {
    private String name;
    @OneToMany(mappedBy = "cityId")
    private List<Airport> airports = new ArrayList<>(); //todo при update выдаёт  "errorMessage": "could not execute statement; SQL [n/a]; constraint [timezone\" of relation \"airport]"
}
