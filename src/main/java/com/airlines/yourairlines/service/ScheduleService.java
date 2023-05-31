package com.airlines.yourairlines.service;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Getter
@Setter
public class ScheduleService {

  @Autowired private EventLogService eventLogService;
  @Autowired private DayChangeService dayChangeService;

  @Scheduled(fixedDelay = 1000)
  private void makeScheduledDisplayedTasks() {
    dayChangeService.displayCurrentDate();
    eventLogService.displayEvent();
  }

  @Scheduled(fixedDelayString = "${frequency.of.sync}000")
  private void makeScheduledTasks() {
    eventLogService.syncEventLog();
  }
}
