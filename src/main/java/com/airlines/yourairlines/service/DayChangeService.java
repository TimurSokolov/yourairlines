package com.airlines.yourairlines.service;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@Getter
@Setter
public class DayChangeService {
    @Lazy
    @Autowired
    private EventLogService eventLogService;
    private LocalDateTime currentDate = LocalDateTime.of(2023, 1, 1, 0, 0);
    private Integer increaseHour = 1;
    private Integer increaseMinutes = 0;


    public void changeCurrentDateRate(Integer increaseHour, Integer increaseMinutes) {
        this.increaseMinutes = increaseMinutes;
        this.increaseHour = increaseHour;
        eventLogService.syncEventLog();
    }

    public void displayCurrentDate() {
        currentDate = currentDate.plusHours(increaseHour).plusMinutes(increaseMinutes);
        log.info("Current date: {}", currentDate);
    }

}
