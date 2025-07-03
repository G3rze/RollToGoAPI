package com.terraplanistas.api.controller.DTO;

import com.terraplanistas.api.model.enums.ProficiencyLevelEnum;
import com.terraplanistas.api.model.enums.SkillTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class SkillCreateDTO {
    @NotBlank(message = "El ID de la habilidad no puede estar vacío")
    private String abilityId;

    @NotNull(message = "El tipo de habilidad no puede ser nulo")
    private SkillTypeEnum skillTypeEnum;

    @NotNull(message = "El nivel de competencia no puede ser nulo")
    private ProficiencyLevelEnum proficiencyLevelEnum;
}
