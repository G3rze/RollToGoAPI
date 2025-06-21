package com.terraplanistas.api.model;

import com.terraplanistas.api.model.enums.CreatureTypeEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "room_creatures")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomCreature {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "creature_id")
    private Creature creature;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @Column(name = "creature_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private CreatureTypeEnum creatureType;
}
