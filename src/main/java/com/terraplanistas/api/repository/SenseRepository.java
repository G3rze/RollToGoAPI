package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.Sense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SenseRepository extends JpaRepository<Sense, UUID> {
}
