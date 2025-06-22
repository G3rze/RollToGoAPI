package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.GrantOptionItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GrantOptionItemRepository extends JpaRepository<GrantOptionItem, UUID> {
}
