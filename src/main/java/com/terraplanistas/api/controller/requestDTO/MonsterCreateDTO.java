package com.terraplanistas.api.controller.requestDTO;

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
public class MonsterCreateDTO {
    @NotBlank(message = "El ID de criatura no puede estar vacío")
    private String creatureId;

    @NotBlank(message = "El valor de desafío no puede estar vacío")
    private String challengeRating;

    @NotNull(message = "El campo 'legendary' no puede ser nulo")
    private Boolean legendary;

    @NotNull(message = "El campo 'lair' no puede ser nulo")
    private Boolean lair;
}
