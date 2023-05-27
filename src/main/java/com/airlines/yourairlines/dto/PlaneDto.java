package com.airlines.yourairlines.dto;

import com.airlines.yourairlines.dto.valiation.Create;
import com.airlines.yourairlines.dto.valiation.Update;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaneDto extends VersionedDto {
    @NotNull(message = "Номер борта обязателен к заполнению", groups = {Create.class, Update.class})
    private String sideNumber;
    @NotNull(message = "Производитель самолёта обязателен к заполнению", groups = {Create.class, Update.class})
    private String brand;
    @NotNull(message = "Модель самолёта обязательна к заполнению", groups = {Create.class, Update.class})
    private String model;
    @NotNull(message = "Максимальная дальность полёта обязательна к заполнению", groups = {Create.class, Update.class})
    private Integer maxFlightRange;
    @NotNull(message = "Максимальная вместительность человек обязательна к заполнению", groups = {Create.class, Update.class})
    private Integer maxNumberOfPeople;
    @NotNull(message = "Расход топлива обязателен к заполнению", groups = {Create.class, Update.class})
    private Integer fuelConsumption;
    @NotNull(message = "Крейсерская скорость обязательна к заполнению", groups = {Create.class, Update.class})
    private Integer cruiseSpeed;
    @NotNull(message = "Стартовый аэропорт обязателен к заполнению при создании нового самолёта", groups = {Create.class})
    private Long startAirportId;
}
