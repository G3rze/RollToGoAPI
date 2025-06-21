package com.terraplanistas.api.model;

import com.terraplanistas.api.model.enums.CreatureSizeEnum;
import com.terraplanistas.api.model.enums.CreatureTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "species")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Species {
    @Id
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Content content;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "creature_type_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private CreatureTypeEnum creatureTypeEnum;

    @Column(name = "languages")
    private String languages;

    @Column(name = "size_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private CreatureSizeEnum sizeEnum;

    @OneToMany(mappedBy = "species", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Subspecies> subspecies;
}
