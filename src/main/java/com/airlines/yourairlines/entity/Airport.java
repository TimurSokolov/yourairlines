package com.airlines.yourairlines.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Airport extends VersionedEntity {

    private String name;
    private String timezone;
    private String lat;
    private String lon;
    private Long cityId;

}
