package com.airlines.yourairlines.dto;

import java.util.Set;

public class Airport extends LongIdDto {
    private City city;
    private String name;
    private Integer timezone;
    private Set<Plane> planeList;
    private Coordinates planeCoordinates;


    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    public Set<Plane> getPlaneList() {
        return planeList;
    }

    public void setPlaneList(Set<Plane> planeList) {
        this.planeList = planeList;
    }

    public Coordinates getPlaneCoordinates() {
        return planeCoordinates;
    }

    public void setPlaneCoordinates(Coordinates planeCoordinates) {
        this.planeCoordinates = planeCoordinates;
    }
}
