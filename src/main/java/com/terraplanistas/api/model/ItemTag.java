package com.terraplanistas.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "item_tags")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemTag {
    @Id
    @ManyToOne
    @JoinColumn(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
    private Item item;

    @Column(name = "tag", nullable = false)
    private String tag;
}
