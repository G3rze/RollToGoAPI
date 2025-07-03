package com.terraplanistas.api.model;

import com.terraplanistas.api.model.enums.CastingTimeUnitEnum;
import com.terraplanistas.api.model.enums.DamageTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "damages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Damage {
    @Id
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Content content;

    @Column(name = "damage_formula", nullable = false)
    private String damageFormula;

    @Column(name = "damage_type_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private DamageTypeEnum damageTypeEnum;

    @Column(name = "repeat", nullable = false)
    private boolean repeat;

    @Column(name = "repeat_time_value")
    private Integer repeatTimeValue;

    @Column(name = "repeat_time_unit")
    @Enumerated(EnumType.STRING)
    private CastingTimeUnitEnum repeatTimeUnit;
}
