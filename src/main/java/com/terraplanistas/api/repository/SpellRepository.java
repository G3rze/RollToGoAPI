package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.Spell;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpellRepository extends JpaRepository<Spell, UUID> {
}
