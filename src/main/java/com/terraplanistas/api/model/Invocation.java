package com.terraplanistas.api.model;

import com.terraplanistas.api.model.enums.DurationUnitEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "invocations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Invocation {
    @Id
    @OneToOne
    @MapsId
    @JoinColumn(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
    private Creature creature;

    @Column(name = "duration_value", nullable = false)
    private Integer durationValue;

    @Column(name = "duration_unit_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private DurationUnitEnum durationUnitEnum;
}
