package com.airlines.yourairlines.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class VersionedDto extends LongIdDto {
    private Long version;
}
