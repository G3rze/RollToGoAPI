package com.terraplanistas.api.controller.DTO;

import com.terraplanistas.api.model.enums.AbilityTypeEnum;
import com.terraplanistas.api.model.enums.BonusTypeEnum;
import com.terraplanistas.api.model.enums.SkillTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class BonusCreateDTO {
    @NotBlank(message = "El ID de contenido no puede estar vacío")
    private String contentId;

    @NotNull(message = "El tipo de bonificación no puede ser nulo")
    private BonusTypeEnum bonusTypeEnum;

    @NotNull(message = "El tipo de habilidad no puede ser nulo")
    private AbilityTypeEnum abilityTypeEnum;

    @NotNull(message = "El tipo de habilidad (skill) no puede ser nulo")
    private SkillTypeEnum skillTypeEnum;

    @NotBlank(message = "La fórmula de los dados no puede estar vacía")
    private String diceFormula;
}

