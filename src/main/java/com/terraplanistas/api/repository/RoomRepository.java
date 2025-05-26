package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoomRepository extends JpaRepository<Room, UUID> {
}
