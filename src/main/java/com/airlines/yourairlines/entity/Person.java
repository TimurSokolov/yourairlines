package com.airlines.yourairlines.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Person extends VersionedEntity {
  private String name;
  private String surname;
  private String phoneNumber;
}
