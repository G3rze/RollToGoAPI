package com.terraplanistas.api.controller.DTO;

import com.terraplanistas.api.model.enums.MovementTypeEnum;
import com.terraplanistas.api.model.enums.RangeUnitEnum;
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
public class MovementCreateDTO {
    @NotBlank(message = "El ID de contenido no puede estar vacío")
    private String contentId;

    @NotNull(message = "El valor máximo de movimiento no puede ser nulo")
    @Min(value = 0, message = "El valor máximo de movimiento no puede ser negativo")
    private Integer maxMovementValue;

    @NotNull(message = "La unidad de movimiento máxima no puede ser nula")
    private RangeUnitEnum maxMovementUnit;

    @NotNull(message = "El tipo de movimiento no puede ser nulo")
    private MovementTypeEnum movementTypeEnum;
}
