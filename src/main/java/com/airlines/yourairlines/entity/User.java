package com.airlines.yourairlines.entity;

import com.airlines.yourairlines.enums.Role;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends VersionedEntity {

    private String password;
    private String login;
    private Role role = Role.ADMIN;
}
