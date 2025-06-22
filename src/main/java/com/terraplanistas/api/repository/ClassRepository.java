package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.Class;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClassRepository extends JpaRepository<Class, UUID> {
}
