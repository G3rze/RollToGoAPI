package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.Monster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MonsterRepository extends JpaRepository<Monster, UUID> {
}
