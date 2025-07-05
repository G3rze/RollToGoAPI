package com.terraplanistas.api.controller.requestDTO;

import com.terraplanistas.api.model.enums.RecoveryTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class LimitedUsageCreateDTO {
    @NotBlank(message = "El ID de contenido no puede estar vacío")
    private String contentId;

    @NotBlank(message = "La fórmula de usos máximos base no puede estar vacía")
    private String baseMaxUsesFormula;

    @NotNull(message = "El campo 'isScaling' no puede ser nulo")
    private Boolean isScaling;

    @NotNull(message = "El número de usos no puede ser nulo")
    @Min(value = 0, message = "El número de usos no puede ser negativo")
    private Integer uses;

    private String scalingFormula;

    @NotNull(message = "El tipo de recuperación no puede ser nulo")
    private RecoveryTypeEnum recoveryTypeEnum;
}