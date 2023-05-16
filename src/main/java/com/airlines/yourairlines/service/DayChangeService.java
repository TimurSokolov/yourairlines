package com.airlines.yourairlines.service;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class DayChangeService {
    @Getter
    @Setter
    private LocalDateTime currentDate = LocalDateTime.of(2023, 1, 1, 0, 0);

    @Scheduled(fixedDelay = 1000)
    private void changeCurrentDate() {
        currentDate = currentDate.plusHours(1);
        log.info("Current date: {}", currentDate);
    }

}
