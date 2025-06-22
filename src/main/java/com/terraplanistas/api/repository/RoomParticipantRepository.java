package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.RoomParticipant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoomParticipantRepository extends JpaRepository<RoomParticipant, UUID> {
}
