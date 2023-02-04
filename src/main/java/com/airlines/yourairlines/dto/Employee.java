package com.airlines.yourairlines.dto;

import com.airlines.yourairlines.annotation.UserAuthenticationControllerLink;
import lombok.Getter;
import lombok.Setter;

@UserAuthenticationControllerLink(userType = "/employee")
@Getter
@Setter
public class Employee extends User {
    private Long employeeId;

}
