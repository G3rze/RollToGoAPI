package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.Feat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FeatRepository extends JpaRepository<Feat, UUID> {
}
