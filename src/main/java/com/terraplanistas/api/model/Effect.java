package com.terraplanistas.api.model;

import com.terraplanistas.api.model.enums.ConditionTypeEnum;
import com.terraplanistas.api.model.enums.DurationUnitEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "effects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Effect {
    @Id
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Content content;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "condition_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private ConditionTypeEnum conditionEnum;

    @Column(name = "duration_value", nullable = false)
    private Integer durationValue;

    @Column(name = "duration_unit", nullable = false)
    @Enumerated(EnumType.STRING)
    private DurationUnitEnum durationUnit;

}
