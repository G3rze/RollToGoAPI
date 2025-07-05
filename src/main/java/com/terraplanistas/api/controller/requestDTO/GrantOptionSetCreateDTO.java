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
public class GrantOptionSetCreateDTO {
    @NotBlank(message = "El ID de contenido otorgante no puede ser nulo")
    private String granterContentId;

    @NotNull(message = "El número mínimo de elecciones no puede ser nulo")
    @Min(value = 0, message = "El número mínimo de elecciones no puede ser negativo")
    private Integer minChoices;

    @NotNull(message = "El número máximo de elecciones no puede ser nulo")
    @Min(value = 0, message = "El número máximo de elecciones no puede ser negativo")
    private Integer maxChoices;
}
