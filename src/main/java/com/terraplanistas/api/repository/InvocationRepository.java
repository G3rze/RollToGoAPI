package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.Invocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvocationRepository extends JpaRepository<Invocation, UUID> {
}
