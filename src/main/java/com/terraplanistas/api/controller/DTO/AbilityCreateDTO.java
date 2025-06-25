package com.terraplanistas.api.controller.DTO;

import com.terraplanistas.api.model.enums.AbilityTypeEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class AbilityCreateDTO {
    @NotBlank(message = "contentId es requerido")
    private String contentId;

    @NotBlank(message = "abilityTypeEnum no puede estar vacío")
    private AbilityTypeEnum abilityTypeEnum;

    private int modifier;

    private int value;
}
