package com.airlines.yourairlines.dto;

import com.airlines.yourairlines.dto.valiation.Create;
import com.airlines.yourairlines.dto.valiation.Update;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterRequest {

  @NotNull(
      message = "Поле 'Имя' обязательно для заполнения",
      groups = {Create.class, Update.class})
  private String name;

  @NotNull(
      message = "Поле 'Логин' обязательно для заполнения",
      groups = {Create.class, Update.class})
  private String login;

  @NotNull(
      message = "Поле 'Пароль' обязательно для заполнения",
      groups = {Create.class, Update.class})
  private String password;
}
