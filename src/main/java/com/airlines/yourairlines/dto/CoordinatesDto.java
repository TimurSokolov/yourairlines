package com.airlines.yourairlines.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class CoordinatesDto implements Serializable {

    public Double lat;
    public Double lon;

    @Override
    public String toString() {
        return lat +
                "," + lon;
    }
}
