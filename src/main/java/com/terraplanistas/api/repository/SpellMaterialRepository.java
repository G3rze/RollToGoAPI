package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.SpellMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpellMaterialRepository extends JpaRepository<SpellMaterial, UUID> {
}
