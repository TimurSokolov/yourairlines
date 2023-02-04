package com.airlines.yourairlines.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Client extends User {
    private String email;
    private String cardNumber;
    private String homeAirport;


}
