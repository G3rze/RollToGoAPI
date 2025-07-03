package com.terraplanistas.api.model;

import com.terraplanistas.api.model.enums.CurrencyEnum;
import com.terraplanistas.api.model.enums.ItemTypeEnum;
import com.terraplanistas.api.model.enums.RarityEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Content content;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "item_type_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private ItemTypeEnum itemTypeEnum;

    @Column(name = "rarity_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private RarityEnum rarityEnum;

    @Column(name = "weight", nullable = false)
    private Double weight;

    @Column(name = "cost_value", nullable = false)
    private Double costValue;

    @Column(name = "cost_currency", nullable = false)
    @Enumerated(EnumType.STRING)
    private CurrencyEnum costCurrency;

    @Column(name = "attuntement_required")
    private Boolean attunementRequired;

    @Column(name = "is_magic")
    private Boolean isMagic;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemTag> itemTags;
}
