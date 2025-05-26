package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.RoomParticipant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoomParticipantsRepository extends JpaRepository<RoomParticipant, UUID> {
    // Custom query methods can be defined here if needed
}
