package com.terraplanistas.api.controller.requestDTO;

import com.terraplanistas.api.model.enums.AbilityTypeEnum;
import com.terraplanistas.api.model.enums.SpellcastingProgressionEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class SpellcastingCreateDTO {
    @NotNull(message = "El ID de la clase no puede ser nulo")
    private String classId;

    @NotNull(message = "La progresión de lanzamiento de conjuros no puede ser nula")
    private SpellcastingProgressionEnum spellcastingProgressionEnum;

    @NotNull(message = "La habilidad de lanzamiento de conjuros no puede ser nula")
    private AbilityTypeEnum spellcastingAbility;

    private String preparationFormula;
}
