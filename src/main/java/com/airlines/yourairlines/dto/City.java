package com.airlines.yourairlines.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City extends LongIdDto {
    private String name;
    private Coordinates CityCoordinates;
}
