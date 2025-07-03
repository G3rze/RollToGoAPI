package com.terraplanistas.api.model;

import com.terraplanistas.api.model.enums.AbilityTypeEnum;
import com.terraplanistas.api.model.enums.SpellcastingProgressionEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "spellcasting")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Spellcasting {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "class_id", nullable = false)
    private Class clazz;

    @Column(name = "spellcasting_progression_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private SpellcastingProgressionEnum spellcastingProgressionEnum;

    @Column(name = "spellcasting_ability", nullable = false)
    @Enumerated(EnumType.STRING)
    private AbilityTypeEnum spellcastingAbility;

    @Column(name = "preparation_formula")
    private String preparationFormula;
}
