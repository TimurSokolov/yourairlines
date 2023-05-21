package com.airlines.yourairlines.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotNull
    private String name;

    @NotNull
    private String login;

    @NotNull
    private String password;
}
