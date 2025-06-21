package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContentRepository extends JpaRepository<Content, UUID> {
}
