package com.terraplanistas.api.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "classes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Class {
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

    @Column(name = "hit_dice", nullable = false)
    private String hitDice;

    @Column(name = "hit_points_first_level", nullable = false)
    private Integer hitPointsFirstLevel;

    @Column(name = "hit_points_per_level", nullable = false)
    private String hitPointsPerLevel;

    @OneToMany(mappedBy = "clazz")
    private List<Spellcasting> spellcasting;

    @OneToMany(mappedBy = "clazz")
    private List<Subclass> subclasses;
}
