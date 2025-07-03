package com.terraplanistas.api.model;

import com.terraplanistas.api.model.enums.AbilityTypeEnum;
import com.terraplanistas.api.model.enums.BonusTypeEnum;
import com.terraplanistas.api.model.enums.SkillTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "bonuses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bonus {
    @Id
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Content content;

    @Column(name = "bonus_type_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private BonusTypeEnum bonusTypeEnum;

    @Column(name = "ability_type_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private AbilityTypeEnum abilityTypeEnum;

    @Column(name = "skill_type_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private SkillTypeEnum skillTypeEnum;

    @Column(name = "dice_formula", nullable = false)
    private String diceFormula;


}
