package com.airlines.yourairlines.dto;

import com.airlines.yourairlines.entity.Airport;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientDto extends PersonDto {
    private String email;
    private String cardNumber;
    private Airport homeAirport;
    private String login;
    private String password;
}
