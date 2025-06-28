package com.terraplanistas.api.controller.DTO;

import com.terraplanistas.api.model.enums.CreatureSizeEnum;
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
public class SubspeciesCreateDTO {
    @NotBlank(message = "El ID de contenido no puede estar vacío")
    private String contentId;

    @NotBlank(message = "El ID de la especie no puede ser nulo")
    private String speciesId;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    private String description;

    private String languages;

    @NotNull(message = "El tamaño no puede ser nulo")
    private CreatureSizeEnum sizeEnum;
}
