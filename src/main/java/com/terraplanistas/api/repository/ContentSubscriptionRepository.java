package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.ContentSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContentSubscriptionRepository extends JpaRepository<ContentSubscription, UUID> {
    // Additional query methods can be defined here if needed
    // For example, to find by user or content, you could add:
    // List<ContentSubscription> findByUserId(UUID userId);
    // List<ContentSubscription> findByContentId(UUID contentId);
}
