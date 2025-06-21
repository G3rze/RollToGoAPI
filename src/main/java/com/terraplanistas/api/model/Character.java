package com.terraplanistas.api.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "characters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Character {
    @Id
    @OneToOne
    @MapsId
    @JoinColumn(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
    private Creature creature;

    @Column(name = "race")
    private Integer race;

    @Column(name = "character_class")
    private Integer characterClass;

    @Column(name = "name")
    private String name;

    @Column(name = "alignment")
    private Integer alignment;

    @Column(name = "age")
    private String age;

    @Column(name = "ideals")
    private String ideals;

    @Column(name = "personality")
    private String personality;

    @Column(name = "flaws")
    private String flaws;

    @Column(name = "biography")
    private String biography;

    @Column(name = "appearance")
    private String appearance;

    @Column(name = "height")
    private String height;

    @Column(name = "weight")
    private String weight;

    @Column(name = "skin_color")
    private String skinColor;

    @Column(name = "hair_color")
    private String hairColor;

    @Column(name = "faith")
    private String faith;

    @Column(name = "eye_color")
    private String eyeColor;

    @Column(name = "gender")
    private Integer gender;
}
