package com.airlines.yourairlines.service;

import com.airlines.yourairlines.dto.CoordinatesDto;
import com.airlines.yourairlines.entity.Airport;

public interface IMapService {
  CoordinatesDto geoCoding(String address);

  String geoDecoding(String lat, String lon);

  Double calcDistanceBetweenPoints(String arrivalAddress, String destinationAddress);

  Double calcDistanceBetweenPoints(Airport arrivalAirport, Airport destinationAirport);
}
