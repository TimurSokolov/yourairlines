package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.service.DayChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daychange")
public class DayChangeController {
    @Autowired
    DayChangeService dayChangeService;

    @GetMapping("/changecurrentdaterate")
    public String changeCurrentDateRate(@RequestParam Integer increaseHour, Integer increaseMinute) {
        dayChangeService.setIncreaseHour(increaseHour);
        dayChangeService.setIncreaseMinutes(increaseMinute);
        return "Прибавляется по " + increaseHour + " ч. и " + increaseMinute + " мин.";
    }
}
