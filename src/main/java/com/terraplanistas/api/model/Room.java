package com.terraplanistas.api.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "room")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @ManyToOne
    @JoinColumn(name = "current_dm_id", nullable = false)
    private User currentDm;

    @Column(name = "scene_state", columnDefinition = "jsonb", nullable = false)
    private String sceneState;

    @Column(nullable = false)
    private boolean visibility = false;
}