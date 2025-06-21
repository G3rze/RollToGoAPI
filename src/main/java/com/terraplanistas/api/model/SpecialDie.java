package com.terraplanistas.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "special_die")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpecialDie {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "feature_id", nullable = false)
    private Feature feature;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "die_formula", nullable = false)
    private String dieFormula;
}
