package com.terraplanistas.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "spell_materials")
@IdClass(SpellMaterial.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpellMaterial {
    @Id
    @Column(name = "spell_id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID spellId;

    @Id
    @Column(name = "item_id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID itemId;

    @ManyToOne
    @MapsId("spellId")
    @JoinColumn(name = "spell_id", referencedColumnName = "id")
    private Spell spell;

    @ManyToOne
    @MapsId("materialId")
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;

}

