package com.terraplanistas.api.controller.DTO;

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
public class FeatureCreateDTO {
    @NotBlank(message = "El ID de contenido no puede estar vacío")
    private String contentId;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    private String description;

    @NotNull(message = "El campo 'isMagic' no puede ser nulo")
    private Boolean isMagic;

    @NotNull(message = "El campo 'isPassive' no puede ser nulo")
    private Boolean isPassive;
}