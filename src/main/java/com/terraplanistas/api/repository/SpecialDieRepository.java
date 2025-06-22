package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.SpecialDie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpecialDieRepository extends JpaRepository<SpecialDie, UUID> {
}
