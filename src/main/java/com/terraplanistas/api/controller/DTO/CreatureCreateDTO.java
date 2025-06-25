package com.terraplanistas.api.controller.DTO;

import com.terraplanistas.api.model.enums.AlignmentEnum;
import com.terraplanistas.api.model.enums.CreatureSizeEnum;
import com.terraplanistas.api.model.enums.CreatureSourceType;
import com.terraplanistas.api.model.enums.CreatureTypeEnum;
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
public class CreatureCreateDTO {
    @NotBlank(message = "El ID de contenido no puede estar vacío")
    private String contentId;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    @NotNull(message = "El tamaño de la criatura no puede ser nulo")
    private CreatureSizeEnum sizeEnum;

    @NotNull(message = "El tipo de criatura no puede ser nulo")
    private CreatureTypeEnum typeEnum;

    @NotNull(message = "El alineamiento no puede ser nulo")
    private AlignmentEnum alignmentEnum;

    @NotNull(message = "Los puntos de vida base no pueden ser nulos")
    @Min(value = 0, message = "Los puntos de vida base no pueden ser negativos")
    private Integer baseHp;

    @NotNull(message = "La CA base no puede ser nula")
    @Min(value = 0, message = "La CA base no puede ser negativa")
    private Integer baseAc;

    @NotNull(message = "El tipo de fuente de la criatura no puede ser nulo")
    private CreatureSourceType creatureSourceType;
}
