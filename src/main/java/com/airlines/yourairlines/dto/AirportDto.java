package com.airlines.yourairlines.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirportDto extends VersionedDto {
    private Long cityId;  //todo поставить проверку
    private String name;
    private String timezone;
    private String lat;
    private String lon;

}
