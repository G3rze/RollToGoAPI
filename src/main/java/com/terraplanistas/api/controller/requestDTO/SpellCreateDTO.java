package com.terraplanistas.api.controller.requestDTO;

import com.terraplanistas.api.model.enums.*;
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
public class SpellCreateDTO {
    @NotBlank(message = "El ID de contenido no puede estar vacío")
    private String contentId;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    private String description;

    @NotBlank(message = "Los componentes del hechizo no pueden estar vacíos")
    private String spellComponents;

    @NotNull(message = "El nivel del hechizo no puede ser nulo")
    private SpellLevelEnum spellLevelEnum;

    @NotNull(message = "La escuela del hechizo no puede ser nula")
    private SpellSchoolEnum spellSchoolEnum;

    @NotNull(message = "El valor del tiempo de lanzamiento no puede ser nulo")
    @Min(value = 0, message = "El valor del tiempo de lanzamiento no puede ser negativo")
    private Integer castingTimeValue;

    @NotNull(message = "La unidad del tiempo de lanzamiento no puede ser nula")
    private CastingTimeUnitEnum castingTimeUnitEnum;

    @NotNull(message = "El valor del rango no puede ser nulo")
    @Min(value = 0, message = "El valor del rango no puede ser negativo")
    private Integer rangeValue;

    @NotNull(message = "La unidad de rango no puede ser nula")
    private RangeUnitEnum rangeUnitEnum;

    @NotNull(message = "El valor de la duración no puede ser nulo")
    @Min(value = 0, message = "El valor de la duración no puede ser negativo")
    private Integer durationValue;

    @NotNull(message = "La unidad de duración no puede ser nula")
    private DurationUnitEnum durationUnitEnum;

    @NotNull(message = "El campo 'isRitual' no puede ser nulo")
    private Boolean isRitual;
}