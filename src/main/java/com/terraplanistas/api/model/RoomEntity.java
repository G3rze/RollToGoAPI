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
public class RoomEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "participant_id")
    private RoomParticipant participant;

    @ManyToOne
    @JoinColumn(name = "content_id")
    private Content content;

    @Column(columnDefinition = "jsonb", nullable = false)
    private String state;
}
