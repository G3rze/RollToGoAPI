package com.terraplanistas.api.controller.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class SpecialDieCreateDTO {
    @NotNull(message = "El ID de la característica no puede ser nulo")
    private String featureId;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    @NotNull(message = "La cantidad no puede ser nula")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private Integer quantity;

    @NotBlank(message = "La fórmula del dado no puede estar vacía")
    private String dieFormula;
}
