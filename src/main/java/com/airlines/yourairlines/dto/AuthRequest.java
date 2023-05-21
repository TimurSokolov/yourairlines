package com.airlines.yourairlines.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AuthRequest {

    @NotNull
    private String login;

    @NotNull
    private String password;
}
