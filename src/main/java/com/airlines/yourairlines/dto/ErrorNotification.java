package com.airlines.yourairlines.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ErrorNotification {

    private List<String> errorMessages;
}
