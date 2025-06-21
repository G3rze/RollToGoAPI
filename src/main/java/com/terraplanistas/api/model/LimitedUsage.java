package com.terraplanistas.api.model;

import com.terraplanistas.api.model.enums.RecoveryTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "limited_usages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LimitedUsage {
    @Id
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Content content;

    @Column(name = "base_max_uses_formula", nullable = false)
    private String baseMaxUsesFormula;

    @Column(name = "is_scaling", nullable = false)
    private boolean isScaling;

    @Column(name = "uses", nullable = false)
    private int uses;

    @Column(name = "scaling_formula")
    private String scalingFormula;

    @Column(name = "recovery_type_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private RecoveryTypeEnum recoveryTypeEnum;
}
