package com.terraplanistas.api.controller.requestDTO;

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
public class InvocationCreateDTO {
    @NotBlank(message = "El ID de criatura no puede estar vacío")
    private String creatureId;

    @NotNull(message = "El valor de la duración no puede ser nulo")
    @Min(value = 0, message = "El valor de la duración no puede ser negativo")
    private Integer durationValue;

    @NotNull(message = "La unidad de duración no puede ser nula")
    private DurationUnitEnum durationUnitEnum;
}
