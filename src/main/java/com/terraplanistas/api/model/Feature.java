package com.terraplanistas.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "features")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Feature {
    @Id
    @OneToOne
    @MapsId
    @JoinColumn(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
    private Content content;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "is_magic", nullable = false)
    private boolean isMagic;

    @Column(name = "is_passive", nullable = false)
    private boolean isPassive;

    @OneToMany(mappedBy = "feature")
    private List<SpecialDie> specialDies;
}
