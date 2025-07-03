package com.terraplanistas.api.model;

import com.terraplanistas.api.model.enums.ProficiencyLevelEnum;
import com.terraplanistas.api.model.enums.SkillTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "skills")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Skill {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;


    @Column(name = "skill_type_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private SkillTypeEnum skillTypeEnum;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "ability_id")
    private Ability ability;


    @Column(name = "proficiency_level_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProficiencyLevelEnum proficiencyLevelEnum;
}
