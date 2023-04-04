package com.airlines.yourairlines.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * Абстрактная DTO, содержащая только ID
 */

@Getter
@Setter
@EqualsAndHashCode
public abstract class LongIdDto {
    private Long id;

}
