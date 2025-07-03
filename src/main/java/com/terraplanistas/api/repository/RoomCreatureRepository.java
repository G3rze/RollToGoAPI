package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.RoomCreature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoomCreatureRepository extends JpaRepository<RoomCreature, UUID> {
}
