package com.airlines.yourairlines.service;

import com.airlines.yourairlines.entity.Airport;
import com.airlines.yourairlines.entity.Flight;
import com.airlines.yourairlines.entity.LongIdEntity;
import com.airlines.yourairlines.entity.Plane;
import com.airlines.yourairlines.enums.PlaneState;
import com.airlines.yourairlines.exception.NotFoundException;
import com.airlines.yourairlines.repository.IBaseRepository;
import com.airlines.yourairlines.repository.IPlaneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;


@Service
@Slf4j
public class PlaneService extends CrudService<Plane> implements IPlaneService {
    @Autowired
    private IPlaneRepository planeRepository;
    @Autowired
    private DayChangeService dayChangeService;
    @Autowired
    private IAirportService airportService;
    @Lazy
    @Autowired
    private IFlightService flightService;

    @Override
    public IBaseRepository<Plane> getRepository() {
        return planeRepository;
    }

    @Override
    protected void validate(Plane plane) {
    }

    public PlaneState getPlaneState(Long planeId) {

        Plane plane = findById(planeId);

        if (isPlaneInFlightNow(plane)) {
            return PlaneState.IN_FLIGHT;
        } else if (isPlaneReservedOnFuture(plane)) {
            return PlaneState.NOT_RESERVED;
        }

        return PlaneState.RESERVED;
    }

    private boolean isPlaneInFlightNow(Plane plane) {
        ArrayList<Boolean> arrayList = planeRepository.checkPlaneInFlightNow(plane.getId(), dayChangeService.getCurrentDate());
        return arrayList.stream().anyMatch(s -> s.equals(true));
    }

    private boolean isPlaneReservedOnFuture(Plane plane) {
        return flightService.calcLastReservedArrivalTime(plane).isBefore(dayChangeService.getCurrentDate());
    }

    public String getSideNumberById(Long id) {
        return findById(id).getSideNumber();
    }

    @Override
    public ArrayList<Plane> findSuitablePlanes(Long departureAirportId, Long arrivalAirportId, LocalDateTime departureTime) {
        Airport departureAirport = airportService.findById(departureAirportId);
        Airport arrivalAirport = airportService.findById(arrivalAirportId);

        Integer flightDistance = flightService.calcFlightDistance(departureAirport, arrivalAirport);

        return planeRepository.findSuitablePlanes(flightDistance, departureTime, departureAirportId);
    }

    public Plane findById(Long id) {
        Optional<Plane> planeOptional = planeRepository.findById(id);
        return planeOptional.orElseThrow(() -> new NotFoundException(String.format("Борт с id = %s не найден", id)));
    }

    @Override
    public Plane save(Plane planeToSave, Long startAirportId) {
        Flight flight = new Flight();
        planeToSave = planeRepository.save(planeToSave);
        flight.setDepartureTime(dayChangeService.getCurrentDate());
        flight.setArrivalTime(dayChangeService.getCurrentDate());
        flight.setDepartureAirportId(startAirportId);
        flight.setArrivalAirportId(startAirportId);
        flight.setReservedPlaneId(planeToSave.getId());
        flightService.save(flight);
        return super.save(planeToSave);
    }

    @Override
    public void delete(Long id) {
        ArrayList<Flight> flightsToDelete = flightService.findByReservedPlaneId(id);
        flightsToDelete.stream().map(LongIdEntity::getId).forEach(flightId -> flightService.delete(flightId));
        Plane plane = findById(id);
        planeRepository.delete(plane);
    }
}
