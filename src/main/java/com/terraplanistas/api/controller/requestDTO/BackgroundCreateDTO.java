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
public class BackgroundCreateDTO {
    @NotBlank(message = "Content ID no puede ser vacío")
    private String contentId;

    @NotBlank(message = "Nombre no peude ser vacío")
    private String name;

    private String description;
}
