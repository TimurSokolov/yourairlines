package com.airlines.yourairlines.service;

import com.airlines.yourairlines.entity.Flight;
import com.airlines.yourairlines.entity.Plane;
import com.airlines.yourairlines.enums.PlaneState;
import com.airlines.yourairlines.exception.NotFoundException;
import com.airlines.yourairlines.repository.IBaseRepository;
import com.airlines.yourairlines.repository.IPlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;

@Service
public class PlaneService extends CrudService<Plane> implements IPlaneService {
    @Autowired
    private IPlaneRepository planeRepository;
    @Autowired
    private DayChangeService dayChangeService;
/*    @Autowired
    private IFlightService flightService;*/

    @Override
    public IBaseRepository<Plane> getRepository() {
        return planeRepository;
    }

    @Override
    protected void validate(Plane entity) {
        if (entity.getEndOfReserveTime() == null) {
            entity.setEndOfReserveTime(LocalDateTime.of(2023, 1, 1, 0, 0));
        }
    }

    public PlaneState getPlaneState(Long planeId) {  //todo передавать entity или id?
        Plane plane = planeRepository.findById(planeId).orElseThrow(() -> new NotFoundException("Самолёт с id " + planeId + " не найден"));
        if (plane.getReservedFlights().stream().anyMatch(s -> s.getDepartureTime().isBefore(dayChangeService.getCurrentDate()) && s.getArrivalTime().isAfter(dayChangeService.getCurrentDate()))) {
            return PlaneState.IN_FLIGHT;
        } else if (plane.getReservedFlights().stream().max(Comparator.comparing(Flight::getArrivalTime)).get().getArrivalTime().isBefore(dayChangeService.getCurrentDate())) {
            //else if (flightService.calcLastReservedArrivalTime(plane).isBefore(dayChangeService.getCurrentDate())) todo цикл бинов?
            return PlaneState.NOT_RESERVED;
        }

        return PlaneState.RESERVED;

    }
}
