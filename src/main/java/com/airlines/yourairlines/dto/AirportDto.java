package com.airlines.yourairlines.dto;

import com.airlines.yourairlines.entity.City;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirportDto extends VersionedDto {
    private City homeCity;
    private String name;
    private String timezone;
}
