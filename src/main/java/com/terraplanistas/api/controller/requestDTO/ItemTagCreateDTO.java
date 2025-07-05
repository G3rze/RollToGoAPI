package com.terraplanistas.api.controller.requestDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ItemTagCreateDTO {
    @NotBlank(message = "El ID del ítem no puede estar vacío")
    private String itemId;

    @NotBlank(message = "La etiqueta no puede estar vacía")
    private String tag;
}