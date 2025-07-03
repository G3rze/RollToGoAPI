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

public class ClassCreateDTO {
    @NotBlank(message = "El ID de contenido no puede estar vacío")
    private String contentId;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    private String description;

    @NotBlank(message = "Los dados de golpe no pueden estar vacíos")
    private String hitDice;

    @NotNull(message = "Los puntos de golpe del primer nivel no pueden ser nulos")
    private Integer hitPointsFirstLevel;

    @NotBlank(message = "Los puntos de golpe por nivel no pueden estar vacíos")
    private String hitPointsPerLevel;
}
