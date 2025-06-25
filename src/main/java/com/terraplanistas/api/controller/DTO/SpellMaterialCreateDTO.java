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
public class SpellMaterialCreateDTO {
    @NotBlank(message = "El ID del hechizo no puede ser nulo")
    private String spellId;

    @NotBlank(message = "El ID del ítem no puede ser nulo")
    private String itemId;
}
