package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.Bonus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BonusRepository extends JpaRepository<Bonus, UUID> {
}
