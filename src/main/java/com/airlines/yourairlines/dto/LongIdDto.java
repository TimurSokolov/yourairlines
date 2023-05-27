package com.airlines.yourairlines.dto;

import com.airlines.yourairlines.dto.valiation.Create;
import com.airlines.yourairlines.dto.valiation.Update;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Абстрактная DTO, содержащая только ID
 */

@Getter
@Setter
@EqualsAndHashCode
public abstract class LongIdDto {
    @NotNull(message = "Поле 'id' обязательно для заполнения", groups = {Update.class})
    @Null(message = "Поле 'id' не должно быть заполнено", groups = {Create.class})
    private Long id;

}
