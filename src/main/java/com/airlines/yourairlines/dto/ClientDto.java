package com.airlines.yourairlines.dto;

import com.airlines.yourairlines.dto.valiation.Create;
import com.airlines.yourairlines.dto.valiation.Update;
import com.airlines.yourairlines.entity.Airport;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientDto extends PersonDto {
    @Email
    private String email;
    private String cardNumber;
    @NotNull(message = "Поле 'Домашний аэропорт' обязательно для заполнения", groups = {Create.class, Update.class})
    private Airport homeAirport;
}
