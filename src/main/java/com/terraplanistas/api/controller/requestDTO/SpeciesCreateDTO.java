package com.terraplanistas.api.controller.requestDTO;

import com.terraplanistas.api.model.enums.CreatureSizeEnum;
import com.terraplanistas.api.model.enums.CreatureTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class SpeciesCreateDTO {
    @NotBlank(message = "El ID de contenido no puede estar vacío")
    private String contentId;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    private String description;

    @NotNull(message = "El tipo de criatura no puede ser nulo")
    private CreatureTypeEnum creatureTypeEnum;

    private String languages;

    @NotNull(message = "El tamaño no puede ser nulo")
    private CreatureSizeEnum sizeEnum;
}