package com.airlines.yourairlines.service;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@Getter
@Setter

public class DayChangeService {

    private LocalDateTime currentDate = LocalDateTime.of(2023, 1, 1, 0, 0);
    private Integer increaseHour = 1;
    private Integer increaseMinute = 0;

    @Scheduled(fixedDelay = 1000)
    private void changeCurrentDate() {
        currentDate = currentDate.plusHours(increaseHour).minusMinutes(increaseMinute);
        log.info("Current date: {}", currentDate);
    }

}
