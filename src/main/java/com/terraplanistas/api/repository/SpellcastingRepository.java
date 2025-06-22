package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.Spellcasting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpellcastingRepository extends JpaRepository<Spellcasting, UUID> {
}
