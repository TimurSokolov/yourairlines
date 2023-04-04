package com.airlines.yourairlines.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "users")
public class User extends VersionedEntity {

    private String password;
    private String login;
    private String authority;

}
