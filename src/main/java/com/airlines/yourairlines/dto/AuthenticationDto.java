package com.airlines.yourairlines.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthenticationDto {
    private String login;

    private String password;
}
