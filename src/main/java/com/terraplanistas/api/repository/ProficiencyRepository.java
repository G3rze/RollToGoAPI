package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.Proficiency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProficiencyRepository extends JpaRepository<Proficiency, UUID> {
}
