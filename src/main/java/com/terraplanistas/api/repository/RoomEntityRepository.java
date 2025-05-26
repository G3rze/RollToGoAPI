package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoomEntityRepository extends JpaRepository<RoomEntity, UUID> {
}
