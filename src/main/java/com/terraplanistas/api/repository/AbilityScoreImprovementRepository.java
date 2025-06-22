package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.AbilityScoreImprovement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AbilityScoreImprovementRepository extends JpaRepository<AbilityScoreImprovement, UUID> {
}
