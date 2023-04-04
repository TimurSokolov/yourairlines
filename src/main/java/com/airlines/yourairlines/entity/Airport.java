package com.airlines.yourairlines.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Airport extends VersionedEntity {

    private String name;
    private String timezone;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id", nullable = false)
    private City homeCity;
}
