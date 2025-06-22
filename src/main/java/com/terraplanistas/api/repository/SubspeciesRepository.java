package com.terraplanistas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubspeciesRepository extends JpaRepository<SubspeciesRepository, UUID> {
}
