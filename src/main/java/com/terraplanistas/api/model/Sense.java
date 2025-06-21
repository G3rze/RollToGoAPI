package com.terraplanistas.api.model;

import com.terraplanistas.api.model.enums.RangeUnitEnum;
import com.terraplanistas.api.model.enums.SensesTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "senses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sense {
    @Id
    @Column(columnDefinition = "uuid", nullable = false, updatable = false)
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Content content;

    @Column(name = "senses_type_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private SensesTypeEnum sensesTypeEnum;

    @Column(name = "range_value", nullable = false)
    private Integer rangeValue;

    @Column(name = "range_unit_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private RangeUnitEnum rangeUnitEnum;
}
