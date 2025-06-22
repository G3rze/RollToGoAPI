package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.Grant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GrantRepository extends JpaRepository<Grant, UUID> {
}
