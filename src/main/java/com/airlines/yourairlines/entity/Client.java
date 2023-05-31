package com.airlines.yourairlines.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Client extends Person {
  private String email;
  private String cardNumber;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "airport_id", nullable = false)
  private Airport homeAirport;

  private Long user_id;
}
