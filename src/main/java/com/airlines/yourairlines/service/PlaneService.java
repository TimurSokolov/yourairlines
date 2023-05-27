package com.airlines.yourairlines.service;

import com.airlines.yourairlines.entity.Airport;
import com.airlines.yourairlines.entity.Flight;
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
        Plane plane = planeRepository.findById(planeId).orElseThrow(() -> new NotFoundException("Самолёт с id " + planeId + " не найден"));
        if (flightService.findByReservedPlaneId(plane.getId()).stream().anyMatch(s -> s.getDepartureTime().isBefore(dayChangeService.getCurrentDate()) && s.getArrivalTime().isAfter(dayChangeService.getCurrentDate()))) { //todo корректно обращаться сразу в flightRepository?
            return PlaneState.IN_FLIGHT;
        } else if (flightService.calcLastReservedArrivalTime(plane).isBefore(dayChangeService.getCurrentDate())) {
            return PlaneState.NOT_RESERVED;
        }

        return PlaneState.RESERVED;
    }

    public String getSideNumberById(Long id) {
        Optional<Plane> planeOpt = planeRepository.findById(id);
        Plane plane = planeOpt.orElseThrow(() -> new NotFoundException("Борт с id = " + id + " не найден"));
        return plane.getSideNumber();
    }

    @Override
    public ArrayList<Plane> findSuitablePlanes(Long departureAirportId, Long arrivalAirportId, LocalDateTime departureTime) {
        Airport departureAirport = airportService.findById(departureAirportId);
        Airport arrivalAirport = airportService.findById(arrivalAirportId);
        Integer flightDistance = flightService.calcFlightDistance(departureAirport, arrivalAirport);
        String requiredDateTime = departureTime.toString().replaceAll("T", " ").concat(":00");
        log.info("departureTime " + departureTime.toString());
        log.info("requiredDateTimeStr " + requiredDateTime);

        return planeRepository.findSuitablePlanes(flightDistance, departureTime, departureAirportId);
    }

    public Plane findById(Long id) {
        Optional<Plane> planeOptional = planeRepository.findById(id);
        return planeOptional.orElseThrow(() -> new NotFoundException("Борт с id = " + id + " не найден"));
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
}
