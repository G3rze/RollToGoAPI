package com.terraplanistas.api.controller.DTO;

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
public class CharacterCreateDTO {
    @NotBlank(message = "El ID de criatura no puede estar vacío")
    private String creatureId;

    @NotNull(message = "La raza no puede ser nula")
    private Integer race;

    @NotNull(message = "La clase de personaje no puede ser nula")
    private Integer characterClass;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    @NotNull(message = "El alineamiento no puede ser nulo")
    private Integer alignment;

    private String age;

    private String ideals;

    private String personality;

    private String flaws;

    private String biography;

    private String appearance;

    private String height;

    private String weight;

    private String skinColor;

    private String hairColor;

    private String faith;

    private String eyeColor;

    private Integer gender;
}