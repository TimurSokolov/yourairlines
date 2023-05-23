package com.airlines.yourairlines.service;

import com.airlines.yourairlines.entity.Airport;
import com.airlines.yourairlines.entity.Flight;
import com.airlines.yourairlines.entity.Plane;
import com.airlines.yourairlines.repository.IBaseRepository;
import com.airlines.yourairlines.repository.IFlightRepository;
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
    private IMapService mapService;
    @Autowired
    private IAirportService airportService;
    @Autowired
    private IPlaneService planeService;
    @Autowired
    private EventLogService eventLogService;
    @Autowired
    private DayChangeService dayChangeService;

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
        Integer flightDistance = calcFlightDistance(departureAirport, arrivalAirport);
        return (int) (((double) flightDistance / (double) plane.getCruiseSpeed()) * 60);
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
        ArrayList<Plane> suitablePlanes = planeService.findByMaxFlightRangeGreaterThanEqualAndEndOfReserveTimeBefore(calcFlightDistance(departureAirport, arrivalAirport), departureTime);

        return filterPlanesWithHop(suitablePlanes, departureAirport, departureTime);
    }

    private ArrayList<Plane> filterPlanesWithHop(ArrayList<Plane> planes, Airport departureAirport, LocalDateTime departureTime) {

        return planes.stream().filter(plane -> plane.getMaxFlightRange() >= calcFlightDistance(departureAirport, calcLastReservedAirport(plane)))
                .filter(plane -> departureTime.isAfter(calcLastReservedArrivalTime(plane).plusHours(calcFlightDuration(departureAirport, calcLastReservedAirport(plane), plane))))
                .collect(Collectors.toCollection(ArrayList::new));
    }


    private Airport calcLastReservedAirport(Plane plane) {
        ArrayList<Flight> reservedFlights = flightRepository.findByReservedPlaneId(plane.getId());
        return airportService.get(reservedFlights.stream().max(Comparator.comparing(Flight::getArrivalTime)).get().getDepartureAirportId()); //todo как правильно доставать в стриме?
    }

    public LocalDateTime calcLastReservedArrivalTime(Plane plane) {
        ArrayList<Flight> reservedFlights = flightRepository.findByReservedPlaneId(plane.getId());
        return reservedFlights.stream().max(Comparator.comparing(Flight::getArrivalTime)).get().getArrivalTime();
    }

    @Override
    public ArrayList<Flight> findByReservedPlaneId(Long reservedPlaneId) {
        return flightRepository.findByReservedPlaneId(reservedPlaneId);
    }

    @Override
    public ArrayList<Flight> findByDepartureTimeAfterAndDepartureTimeBefore(LocalDateTime startTimeOfSync, LocalDateTime endTimeOfSync) {
        return flightRepository.findByDepartureTimeAfterAndDepartureTimeBefore(startTimeOfSync, endTimeOfSync);
    }

    @Override
    public ArrayList<Flight> findByArrivalTimeAfterAndArrivalTimeBefore(LocalDateTime startTimeOfSync, LocalDateTime endTimeOfSync) {
        return flightRepository.findByArrivalTimeAfterAndArrivalTimeBefore(startTimeOfSync, endTimeOfSync);
    }

    @Override
    public Flight save(Flight flightToSave) {

        Airport departureAirport = airportService.get(flightToSave.getDepartureAirportId());
        Airport arrivalAirport = airportService.get(flightToSave.getArrivalAirportId());
        Plane plane = planeService.get(flightToSave.getReservedPlaneId());

        Integer flightDuration = calcFlightDuration(departureAirport, arrivalAirport, plane);
        flightToSave.setArrivalTime(flightToSave.getDepartureTime().plusMinutes(flightDuration));

        if (flightToSave.getDepartureTime().isAfter(dayChangeService.getCurrentDate())
                && flightToSave.getArrivalTime().isBefore(eventLogService.calcEndTimeOfSync())) {

            eventLogService.syncEventLog();

        }

        if (flightToSave.getArrivalTime().isAfter(dayChangeService.getCurrentDate())
                && flightToSave.getArrivalTime().isBefore(eventLogService.calcEndTimeOfSync())) {

            eventLogService.syncEventLog();

        }
        return flightRepository.save(flightToSave);
    }

}
