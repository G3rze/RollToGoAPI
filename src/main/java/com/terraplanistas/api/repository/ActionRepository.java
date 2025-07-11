package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ActionRepository extends JpaRepository<Action, UUID> {
}
