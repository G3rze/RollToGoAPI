package com.terraplanistas.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "grant_option_sets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GrantOptionSet {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "granter_content_id", nullable = false)
    private Content content;

    @Column(name = "min_choices", nullable = false)
    private Integer minChoices;

    @Column(name = "max_choices", nullable = false)
    private Integer maxChoices;
}
