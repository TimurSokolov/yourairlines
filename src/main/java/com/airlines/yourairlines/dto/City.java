package com.airlines.yourairlines.dto;

public class City extends LongIdDto {
    private String name;
    private Coordinates CityCoordinates;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCityCoordinates() {
        return CityCoordinates;
    }

    public void setCityCoordinates(Coordinates cityCoordinates) {
        CityCoordinates = cityCoordinates;
    }
}
