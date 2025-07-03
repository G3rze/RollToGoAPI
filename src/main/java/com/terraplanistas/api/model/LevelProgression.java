package com.terraplanistas.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "level_progressions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LevelProgression {
    @Id
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Content content;

    @Column(name = "level", nullable = false)
    private Integer level;

    @Column(name = "new_special_value")
    private Integer newSpecialValue;

    @Column(name = "new_special_die_formula")
    private String newSpecialDieFormula;
}
