package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.Background;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BackgroundRepository extends JpaRepository<Background, UUID> {
}
