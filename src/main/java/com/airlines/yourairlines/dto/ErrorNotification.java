package com.airlines.yourairlines.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorNotification {

  private List<String> errorMessages;
}
