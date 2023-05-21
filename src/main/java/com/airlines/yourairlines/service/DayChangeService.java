package com.airlines.yourairlines.service;

import com.airlines.yourairlines.utils.EventLog;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@Slf4j
@Getter
@Setter

public class DayChangeService {
    @Autowired
    private EventLog eventLog;

    private LocalDateTime currentDate = LocalDateTime.of(2023, 1, 1, 0, 0);
    private Integer increaseHour = 1;
    private Integer increaseMinutes = 0;

    @Scheduled(fixedDelay = 1000)
    private void changeCurrentDate() {
        currentDate = currentDate.plusHours(increaseHour).minusMinutes(increaseMinutes);
        log.info("Current date: {}", currentDate);

        ArrayList<LocalDateTime> arrayList = eventLog.getEventLog().keySet().stream()
                .filter(eventDate -> eventDate.isBefore(currentDate))
                .peek((event) -> log.info(eventLog.getEventLog().get(event)))
                .collect(Collectors.toCollection(ArrayList::new));

        arrayList.stream().forEach(eventLog.getEventLog()::remove);
    }

}
