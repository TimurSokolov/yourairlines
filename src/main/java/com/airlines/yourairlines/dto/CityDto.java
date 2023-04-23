package com.airlines.yourairlines.dto;

import com.airlines.yourairlines.entity.Airport;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CityDto extends VersionedDto {
    private String name;
    private List<Airport> airports = new ArrayList<>();
}
