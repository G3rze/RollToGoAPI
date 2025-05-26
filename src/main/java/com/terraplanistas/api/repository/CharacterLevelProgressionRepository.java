package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.CharacterLevelProgression;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CharacterLevelProgressionRepository extends JpaRepository<CharacterLevelProgression, UUID> {

    // Additional query methods can be defined here if needed
    // For example, to find by user or content, you could add:
    // List<CharacterLevelProgression> findByUserId(UUID userId);
    // List<CharacterLevelProgression> findByContentId(UUID contentId);
}
