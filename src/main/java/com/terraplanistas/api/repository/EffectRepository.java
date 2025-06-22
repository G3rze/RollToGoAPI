package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.Effect;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EffectRepository extends JpaRepository<Effect, UUID> {
}
