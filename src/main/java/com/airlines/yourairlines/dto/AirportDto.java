package com.airlines.yourairlines.dto;

import com.airlines.yourairlines.dto.valiation.Create;
import com.airlines.yourairlines.dto.valiation.Update;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirportDto extends VersionedDto {
  @NotNull(
      message = "Поле 'Город' обязательно для заполнения",
      groups = {Create.class, Update.class})
  private Long cityId;

  @NotNull(
      message = "Поле 'Имя' обязательно для заполнения",
      groups = {Create.class, Update.class})
  private String name;

  @NotNull(
      message = "Поле 'Часовой пояс' обязательно для заполнения",
      groups = {Create.class, Update.class})
  private String timezone;

  @NotNull(
      message = "Поле 'Широта' обязательно для заполнения",
      groups = {Create.class, Update.class})
  private String lat;

  @NotNull(
      message = "Поле 'Долгота' обязательно для заполнения",
      groups = {Create.class, Update.class})
  private String lon;
}
