package com.airlines.yourairlines.utils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;

@Component
@Slf4j
@Data
public class EventLog {
    private final HashMap<LocalDateTime, String> eventLog = new HashMap<>();
}
