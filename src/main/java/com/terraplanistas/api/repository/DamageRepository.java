package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.Damage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DamageRepository extends JpaRepository<Damage, UUID> {
}
