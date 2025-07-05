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
public class SpellMaterialCreateDTO {
    @NotBlank(message = "El ID del hechizo no puede ser nulo")
    private String spellId;

    @NotBlank(message = "El ID del ítem no puede ser nulo")
    private String itemId;
}
