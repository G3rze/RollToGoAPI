package com.terraplanistas.api.model;

import com.terraplanistas.api.model.enums.DurationUnitEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "invocations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Invocation {
    @Id
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Creature creature;

    @Column(name = "duration_value", nullable = false)
    private Integer durationValue;

    @Column(name = "duration_unit_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private DurationUnitEnum durationUnitEnum;
}
