package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.Ability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AbilityRepository extends JpaRepository<Ability, UUID> {
}
