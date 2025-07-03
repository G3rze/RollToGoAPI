package com.terraplanistas.api.model;

import com.terraplanistas.api.model.enums.MovementTypeEnum;
import com.terraplanistas.api.model.enums.RangeUnitEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "movements")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movement {
    @Id
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Content content;

    @Column(name = "max_movement_value", nullable = false)
    private Integer maxMovementValue;

    @Column(name = "max_movement_unit", nullable = false)
    @Enumerated(EnumType.STRING)
    private RangeUnitEnum maxMovementUnit;

    @Column(name = "movement_type_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private MovementTypeEnum movementTypeEnum;
}
