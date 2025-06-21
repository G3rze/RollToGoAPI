package com.terraplanistas.api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "monsters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Monster {
    @Id
    @OneToOne
    @MapsId
    @JoinColumn(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
    private Creature creature;

    @Column(name = "challenge_rating", nullable = false)
    private String challengeRating;

    @Column(name = "legendary", nullable = false)
    private Boolean legendary;

    @Column(name = "lair", nullable = false)
    private Boolean lair;
}
