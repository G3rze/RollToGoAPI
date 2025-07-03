package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovementRepository extends JpaRepository<Movement, UUID> {
}
