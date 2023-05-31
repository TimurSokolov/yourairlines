package com.airlines.yourairlines.dto;

import com.airlines.yourairlines.dto.valiation.Create;
import com.airlines.yourairlines.dto.valiation.Update;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class VersionedDto extends LongIdDto {
  @NotNull(
      message = "Поле 'version' обязательно для заполнения",
      groups = {Update.class})
  @Null(
      message = "Поле 'version' не должно быть заполнено",
      groups = {Create.class})
  private Long version;
}
