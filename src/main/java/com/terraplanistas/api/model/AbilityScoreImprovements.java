package com.terraplanistas.api.model;

import com.terraplanistas.api.model.enums.AbilityTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "ability_score_improvements")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AbilityScoreImprovements {
    @Id
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Content content;

    @Column(name = "ability_type_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private AbilityTypeEnum abilityTypeEnum;

    @Column(name = "max_points", nullable = false)
    private Integer maxPoints;
}
