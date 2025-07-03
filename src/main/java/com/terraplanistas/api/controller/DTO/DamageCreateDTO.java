package com.terraplanistas.api.controller.DTO;

import com.terraplanistas.api.model.enums.CastingTimeUnitEnum;
import com.terraplanistas.api.model.enums.DamageTypeEnum;
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
public class DamageCreateDTO {
    @NotBlank(message = "El ID de contenido no puede estar vacío")
    private String contentId;

    @NotBlank(message = "La fórmula de daño no puede estar vacía")
    private String damageFormula;

    @NotNull(message = "El tipo de daño no puede ser nulo")
    private DamageTypeEnum damageTypeEnum;

    @NotNull(message = "El campo 'repeat' no puede ser nulo")
    private Boolean repeat;

    private Integer repeatTimeValue;

    private CastingTimeUnitEnum repeatTimeUnit;
}