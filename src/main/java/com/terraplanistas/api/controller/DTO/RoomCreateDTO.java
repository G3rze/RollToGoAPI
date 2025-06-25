package com.terraplanistas.api.controller.DTO;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class RoomCreateDTO {
    @NotBlank(message = "contentId es requerido")
    private UUID contentId;

    @NotBlank(message = "name no puede estar vacío")
    private String name;

    private String description;

}
