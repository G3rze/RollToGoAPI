package com.terraplanistas.api.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "content")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Content {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 20)
    private String type;

    @ManyToOne
    @JoinColumn(name = "original_owner_id", nullable = false)
    private User originalOwner;

    @ManyToOne
    @JoinColumn(name = "current_owner_id", nullable = false)
    private User currentOwner;

    @Column(columnDefinition = "jsonb", nullable = false)
    private String data;

    @Column(name = "is_homebrew", nullable = false)
    private boolean isHomebrew;

    @Column(columnDefinition = "jsonb", nullable = false)
    private String dependencies;

    @Column(nullable = false)
    private boolean visibility = false;
}