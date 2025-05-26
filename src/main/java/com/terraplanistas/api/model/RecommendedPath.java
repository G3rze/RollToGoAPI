package com.terraplanistas.api.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "room_participants")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecommendedPath {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "character_id")
    private User character;

    @Column(name = "preselected_features", columnDefinition = "jsonb", nullable = false)
    private String preselectedFeatures;
}
