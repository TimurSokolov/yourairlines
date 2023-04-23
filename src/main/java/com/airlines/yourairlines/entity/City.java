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
    @OneToMany(mappedBy = "homeCity")
    private List<Airport> airports = new ArrayList<>();
}
