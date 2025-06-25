package com.terraplanistas.api.controller.DTO;

import com.terraplanistas.api.model.enums.CreatureTypeEnum;
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
public class RoomCreatureCreateDTO {
    @NotBlank(message = "El ID de la criatura no puede ser nulo")
    private String creatureId;

    @NotBlank(message = "El ID del propietario no puede ser nulo")
    private String ownerId;

    @NotBlank(message = "El ID de la sala no puede ser nulo")
    private String roomId;

    @NotNull(message = "El tipo de criatura no puede ser nulo")
    private CreatureTypeEnum creatureType;
}
