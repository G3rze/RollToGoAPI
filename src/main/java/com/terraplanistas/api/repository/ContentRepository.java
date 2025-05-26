package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ContentRepository extends JpaRepository<Content, UUID> {
    // Additional query methods can be defined here if needed
    // For example, to find by title or author, you could add:
    // List<Content> findByTitle(String title);
    // List<Content> findByAuthor(String author);
}
