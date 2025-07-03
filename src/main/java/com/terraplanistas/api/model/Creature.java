package com.terraplanistas.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.terraplanistas.api.model.enums.AlignmentEnum;
import com.terraplanistas.api.model.enums.CreatureSizeEnum;
import com.terraplanistas.api.model.enums.CreatureSourceType;
import com.terraplanistas.api.model.enums.CreatureTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "creatures")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Creature {
    @Id
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Content content;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "size_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private CreatureSizeEnum sizeEnum;

    @Column(name = "type_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private CreatureTypeEnum typeEnum;

    @Column(name = "alignment_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private AlignmentEnum alignmentEnum;

    @Column(name = "base_hp", nullable = false)
    private int baseHp;

    @Column(name = "base_ac", nullable = false)
    private int baseAc;

    @Column(name = "creature_source_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private CreatureSourceType creatureSourceType;

    @OneToOne(mappedBy = "creature", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Monster monsters;

    @OneToOne(mappedBy = "creature", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Invocation invocations;

    @OneToOne(mappedBy = "creature", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private Character character;
}
