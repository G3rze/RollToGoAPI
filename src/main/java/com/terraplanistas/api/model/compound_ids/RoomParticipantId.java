package com.terraplanistas.api.model.compound_ids;

import java.io.Serializable;
import java.util.UUID;

public class RoomParticipantId implements Serializable {
    private UUID room;
    private String user;

    public RoomParticipantId() {}

    public RoomParticipantId(UUID room, String user) {
        this.room = room;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomParticipantId that = (RoomParticipantId) o;
        return room.equals(that.room) && user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(room, user);
    }
}
