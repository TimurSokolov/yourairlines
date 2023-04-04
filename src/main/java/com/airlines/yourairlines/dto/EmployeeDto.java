package com.airlines.yourairlines.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EmployeeDto extends PersonDto {
    private Long employeeId;
    private String login;
    private String password;
}
