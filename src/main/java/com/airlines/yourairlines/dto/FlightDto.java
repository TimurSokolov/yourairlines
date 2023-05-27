package com.airlines.yourairlines.dto;

import com.airlines.yourairlines.dto.valiation.Create;
import com.airlines.yourairlines.dto.valiation.Update;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FlightDto extends VersionedDto {
    @NotNull(message = "Поле 'Аэропорт оправления' обязательно для заполнения", groups = {Create.class, Update.class})
    private Long departureAirportId;
    private LocalDateTime arrivalTime;
    @NotNull(message = "Поле 'Аэропорт назначения' обязательно для заполнения", groups = {Create.class, Update.class})
    private Long arrivalAirportId;
    @NotNull(message = "Поле 'Зарезервированный самолёт' обязательно для заполнения", groups = {Create.class, Update.class})
    private Long reservedPlaneId;
    @NotNull(message = "Поле 'Время отправления' обязательно для заполнения", groups = {Create.class, Update.class})
    private LocalDateTime departureTime;
}
