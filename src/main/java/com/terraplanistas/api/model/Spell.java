package com.terraplanistas.api.model;

import com.terraplanistas.api.model.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "spells")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Spell {
    @Id
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Content content;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "spell_components", nullable = false)
    private String spellComponents;

    @Column(name = "spell_level_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private SpellLevelEnum spellLevelEnum;

    @Column(name = "spell_school_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private SpellSchoolEnum spellSchoolEnum;

    @Column(name = "casting_time_value", nullable = false)
    private int castingTimeValue;

    @Column(name = "casting_time_unit_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private CastingTimeUnitEnum castingTimeUnitEnum;

    @Column(name = "range_value", nullable = false)
    private int rangeValue;

    @Column(name = "range_unit_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private RangeUnitEnum rangeUnitEnum;

    @Column(name = "duration_value", nullable = false)
    private int durationValue;

    @Column(name = "duration_unit_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private DurationUnitEnum durationUnitEnum;

    @Column(name = "is_ritual", nullable = false)
    private boolean isRitual;
}
