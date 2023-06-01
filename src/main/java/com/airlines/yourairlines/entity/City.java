package com.airlines.yourairlines.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class City extends VersionedEntity {
  private String name;

  @OneToMany(mappedBy = "cityId")
  private List<Airport> airports = new ArrayList<>();
}
