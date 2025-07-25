package com.terraplanistas.api.controller.requestDTO;

import com.terraplanistas.api.model.enums.AbilityTypeEnum;
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
public class AbilityScoreImprovementCreateDTO {
    @NotBlank(message = "Contend ID no puede estar vacío")
    private String contentId;
    @NotNull(message = "abilityTypeEnum no puede estar vacío")
    private AbilityTypeEnum abilityTypeEnum;
    @NotNull(message = "maxPoints no puede estar vacío")
    private Integer maxPoints;
}
