package com.airlines.yourairlines.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Абстрактный класс пользователей
 */
@Getter
@Setter

public abstract class User extends LongIdDto {

    private String name;
    private String surname;
    private String login;
    private String password;
    private String phoneNumber;
    private LocalDate birthDate;

}
