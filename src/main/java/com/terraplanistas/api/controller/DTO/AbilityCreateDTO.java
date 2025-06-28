package com.terraplanistas.api.controller.DTO;

import com.terraplanistas.api.model.enums.AbilityTypeEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class AbilityCreateDTO {
    @NotBlank(message = "contentId es requerido")
    private UUID contentId;

    @NotBlank(message = "abilityTypeEnum no puede estar vacío")
    private AbilityTypeEnum abilityTypeEnum;

    private int modifier;

    private int value;
}
