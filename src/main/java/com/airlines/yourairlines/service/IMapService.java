package com.airlines.yourairlines.service;

import com.airlines.yourairlines.dto.CoordinatesDto;

import java.io.IOException;

public interface IMapService {
    CoordinatesDto geoCoding(String address);

    String geoDecoding(String lat, String lon) throws IOException;

    Double calcDistanceBetweenPoints(String arrivalAddress, String destinationAddress) throws IOException;
}
