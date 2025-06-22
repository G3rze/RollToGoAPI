package com.terraplanistas.api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "level_progressions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LevelProgression {
    @Id
    @OneToOne
    @MapsId
    @JoinColumn(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
    private Content content;

    @Column(name = "level", nullable = false)
    private Integer level;

    @Column(name = "new_special_value")
    private Integer newSpecialValue;

    @Column(name = "new_special_die_formula")
    private String newSpecialDieFormula;
}
