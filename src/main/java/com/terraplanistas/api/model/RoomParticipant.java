package com.terraplanistas.api.model;

import com.terraplanistas.api.model.compound_ids.RoomParticipantId;
import com.terraplanistas.api.model.enums.RoleEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "room_participants")
@IdClass(RoomParticipantId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomParticipant {
    @Id
    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "role_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum roleEnum;
}
