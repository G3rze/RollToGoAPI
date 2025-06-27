package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.Room;
import com.terraplanistas.api.model.RoomParticipant;
import com.terraplanistas.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoomParticipantRepository extends JpaRepository<RoomParticipant, UUID> {
    Optional<RoomParticipant> findByRoomAndUser(Room room, User user);
}
