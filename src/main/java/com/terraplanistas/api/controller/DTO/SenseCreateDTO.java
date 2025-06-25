package com.terraplanistas.api.controller.DTO;

import com.terraplanistas.api.model.enums.RangeUnitEnum;
import com.terraplanistas.api.model.enums.SensesTypeEnum;
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
public class SenseCreateDTO {
    @NotBlank(message = "El ID de contenido no puede estar vacío")
    private String contentId;

    @NotNull(message = "El tipo de sentido no puede ser nulo")
    private SensesTypeEnum sensesTypeEnum;

    @NotNull(message = "El valor del rango no puede ser nulo")
    @Min(value = 0, message = "El valor del rango no puede ser negativo")
    private Integer rangeValue;

    @NotNull(message = "La unidad de rango no puede ser nula")
    private RangeUnitEnum rangeUnitEnum;
}
