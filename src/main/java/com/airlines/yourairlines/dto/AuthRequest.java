package com.airlines.yourairlines.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AuthRequest {

  @NotNull(message = "Поле 'Логин' обязательно для заполнения")
  private String login;

  @NotNull(message = "Поле 'Пароль' обязательно для заполнения")
  private String password;
}
