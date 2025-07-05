package com.terraplanistas.api.controller.requestDTO;

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
public class LevelProgressionCreateDTO {
    @NotBlank(message = "El ID de contenido no puede estar vacío")
    private String contentId;

    @NotNull(message = "El nivel no puede ser nulo")
    @Min(value = 1, message = "El nivel debe ser al menos 1")
    private Integer level;

    private Integer newSpecialValue;

    private String newSpecialDieFormula;
}