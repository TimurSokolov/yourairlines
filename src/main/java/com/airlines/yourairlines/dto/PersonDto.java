package com.airlines.yourairlines.dto;

import lombok.Getter;
import lombok.Setter;

/** Абстрактный класс пользователей */
@Getter
@Setter
public abstract class PersonDto extends VersionedDto {
  private String name;
  private String surname;
  private String login;
  private String password;
  private String phoneNumber;
}
