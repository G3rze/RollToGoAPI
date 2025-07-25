package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.GrantOptionSet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GrantOptionSetRepository extends JpaRepository<GrantOptionSet, UUID> {
}
