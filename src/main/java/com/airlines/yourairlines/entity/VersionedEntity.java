package com.airlines.yourairlines.entity;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class VersionedEntity extends LongIdEntity {
    @Version
    private Long version;
}
