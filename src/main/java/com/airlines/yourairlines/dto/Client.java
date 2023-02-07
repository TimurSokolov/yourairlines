package com.airlines.yourairlines.dto;

import com.airlines.yourairlines.annotation.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(tableName = "client")
public class Client extends User {
    private String email;
    private String cardNumber;
    private String homeAirport;


}
