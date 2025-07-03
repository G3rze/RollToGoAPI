package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.Creature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CreatureRepository extends JpaRepository<Creature, UUID> {
}
