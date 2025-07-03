package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.Subclass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubclassRepository extends JpaRepository<Subclass, UUID> {
}
