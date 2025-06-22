package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.LevelProgression;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LevelProgressionRepository extends JpaRepository<LevelProgression, UUID> {
}
