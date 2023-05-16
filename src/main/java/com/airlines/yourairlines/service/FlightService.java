package com.airlines.yourairlines.service;

import com.airlines.yourairlines.entity.Airport;
import com.airlines.yourairlines.entity.Flight;
import com.airlines.yourairlines.entity.Plane;
import com.airlines.yourairlines.repository.IBaseRepository;
import com.airlines.yourairlines.repository.IFlightRepository;
import com.airlines.yourairlines.repository.IPlaneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

@Slf4j
@Service

public class FlightService extends CrudService<Flight> implements IFlightService {
    @Autowired
    private IFlightRepository flightRepository;
    @Autowired
    private IPlaneRepository planeRepository;
    @Autowired
    IMapService mapService;
    @Autowired
    IAirportService airportService;

    @Autowired
    IPlaneService planeService;

    @Override
    public IBaseRepository<Flight> getRepository() {
        return flightRepository;
    }

    @Override
    protected void validate(Flight entity) {

    }

    private Integer calcFlightDuration(Airport departureAirport, Airport arrivalAirport, Plane plane) {
        if (departureAirport == arrivalAirport) {
            return 0;
        }
        return calcFlightDistance(departureAirport, arrivalAirport) / plane.getCruiseSpeed();
    }


    private Integer calcFlightDistance(Airport departureAirport, Airport arrivalAirport) {
        if (departureAirport == arrivalAirport) {
            return 0;
        }
        return mapService.calcDistanceBetweenPoints(departureAirport, arrivalAirport).intValue();
    }


    public ArrayList<Plane> getSuitablePlanes(Long departureAirportId, Long arrivalAirportId, LocalDateTime departureTime) {
        Airport departureAirport = airportService.get(departureAirportId);
        Airport arrivalAirport = airportService.get(arrivalAirportId);
        ArrayList<Plane> suitablePlanes = planeRepository.findByMaxFlightRangeGreaterThanEqualAndEndOfReserveTimeBefore(calcFlightDistance(departureAirport, arrivalAirport), departureTime);

        return filterPlanesWithHop(suitablePlanes, departureAirport, departureTime);
    }

    private ArrayList<Plane> filterPlanesWithHop(ArrayList<Plane> planes, Airport departureAirport, LocalDateTime departureTime) {

        return planes.stream().filter(plane -> plane.getMaxFlightRange() >= calcFlightDistance(departureAirport, calcLastReservedAirport(plane)))
                .filter(plane -> departureTime.isAfter(calcLastReservedArrivalTime(plane).plusHours(calcFlightDuration(departureAirport, calcLastReservedAirport(plane), plane))))
                .collect(Collectors.toCollection(ArrayList::new));
    }


    private Airport calcLastReservedAirport(Plane plane) {
        return airportService.get(plane.getReservedFlights().stream().max(Comparator.comparing(Flight::getArrivalTime)).get().getDepartureAirportId());
    }

    private LocalDateTime calcLastReservedArrivalTime(Plane plane) {
        return plane.getReservedFlights().stream().max(Comparator.comparing(Flight::getArrivalTime)).get().getArrivalTime();
    }

    @Override
    public Flight save(Flight entityToSave) {
        if (entityToSave.getArrivalTime() == null) {
            Integer flightDuration = calcFlightDuration(airportService.get(entityToSave.getDepartureAirportId()), airportService.get(entityToSave.getArrivalAirportId()), planeService.get(entityToSave.getReservedPlaneId()));
            entityToSave.setArrivalTime(entityToSave.getDepartureTime().plusHours(flightDuration));
        }
        return super.save(entityToSave);
    }
}
