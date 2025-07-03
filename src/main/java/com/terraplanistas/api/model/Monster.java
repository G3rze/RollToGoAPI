package com.terraplanistas.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "monsters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Monster {
    @Id
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Creature creature;

    @Column(name = "challenge_rating", nullable = false)
    private String challengeRating;

    @Column(name = "legendary", nullable = false)
    private Boolean legendary;

    @Column(name = "lair", nullable = false)
    private Boolean lair;
}
