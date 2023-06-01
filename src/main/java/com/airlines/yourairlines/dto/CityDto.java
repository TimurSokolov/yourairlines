package com.airlines.yourairlines.dto;

import com.airlines.yourairlines.dto.valiation.Create;
import com.airlines.yourairlines.dto.valiation.Update;
import com.airlines.yourairlines.entity.Airport;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityDto extends VersionedDto {
  @NotNull(
      message = "Поле 'Имя' обязательно для заполнения",
      groups = {Create.class, Update.class})
  private String name;

  private List<Airport> airports = new ArrayList<>();
}
