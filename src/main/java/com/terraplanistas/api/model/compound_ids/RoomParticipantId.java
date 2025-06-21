package com.terraplanistas.api.model.compound_ids;

import java.io.Serializable;
import java.util.UUID;

public class RoomParticipantId implements Serializable {
    private UUID roomId;
    private String userId;

    public RoomParticipantId() {}

    public RoomParticipantId(UUID roomId, String userId) {
        this.roomId = roomId;
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomParticipantId that = (RoomParticipantId) o;
        return roomId.equals(that.roomId) && userId.equals(that.userId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(roomId, userId);
    }
}
