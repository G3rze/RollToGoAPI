package com.terraplanistas.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.terraplanistas.api.model.enums.CreatureSizeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "subspecies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subspecies {
    @Id
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Content content;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "species_id", nullable = false)
    private Species species;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "languages")
    private String languages;

    @Column(name = "size_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private CreatureSizeEnum sizeEnum;
}
