package com.terraplanistas.api.controller.requestDTO;

import com.terraplanistas.api.model.enums.ConditionTypeEnum;
import com.terraplanistas.api.model.enums.DurationUnitEnum;
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
public class EffectCreateDTO {
    @NotBlank(message = "El ID de contenido no puede estar vacío")
    private String contentId;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    private String description;

    @NotNull(message = "El tipo de condición no puede ser nulo")
    private ConditionTypeEnum conditionEnum;

    @NotNull(message = "El valor de la duración no puede ser nulo")
    @Min(value = 0, message = "El valor de la duración no puede ser negativo")
    private Integer durationValue;

    @NotNull(message = "La unidad de duración no puede ser nula")
    private DurationUnitEnum durationUnit;
}
