package com.terraplanistas.api.model;

import com.terraplanistas.api.model.enums.AbilityTypeEnum;
import com.terraplanistas.api.model.enums.ActionTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "actions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Action {
    @Id
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Content content;

    @Enumerated(EnumType.STRING)
    @Column(name = "action_type_enum", nullable = false)
    private ActionTypeEnum actionType;

    @Column(name = "attack_formula", length = 50)
    private String attackFormula;

    @Enumerated(EnumType.STRING)
    @Column(name = "save_ability_type_enum")
    private AbilityTypeEnum saveAbilityType;

    @Column(name = "save_dc_formula", length = 50)
    private String saveDcFormula;

    @Column(name = "is_rolled")
    private Boolean isRolled = false;
}
