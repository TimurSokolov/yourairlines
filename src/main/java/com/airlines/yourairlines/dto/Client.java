package com.airlines.yourairlines.dto;

import com.airlines.yourairlines.annotation.UserAuthenticationControllerLink;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@UserAuthenticationControllerLink(userType = "/client")
public class Client extends User {
    private String email;
    private String cardNumber;
    private String homeAirport;


}
