package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FeatureRepository extends JpaRepository<Feature, UUID> {
}
