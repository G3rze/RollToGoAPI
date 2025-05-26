package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.RecommendedPath;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecommendedPathRepository extends JpaRepository<RecommendedPath, UUID> {
    // Additional query methods can be defined here if needed
    // For example, to find by user or content, you could add:
    // List<RecommendedPath> findByUserId(UUID userId);
    // List<RecommendedPath> findByContentId(UUID contentId);
}
