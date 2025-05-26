package com.terraplanistas.api.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "room_chat")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomChat {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @ManyToOne
    @JoinColumn(name = "room_participant_id", nullable = false)
    private RoomParticipant roomParticipant;

    @Column(columnDefinition = "jsonb", nullable = false)
    private String data;
}