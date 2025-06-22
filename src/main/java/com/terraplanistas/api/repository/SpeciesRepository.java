package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpeciesRepository extends JpaRepository<Species, UUID> {
}
