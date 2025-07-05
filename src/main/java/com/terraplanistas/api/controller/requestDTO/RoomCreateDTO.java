package com.terraplanistas.api.controller.requestDTO;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class RoomCreateDTO {
    @NotBlank(message = "contentId es requerido")
    private String contentId;

    @NotBlank(message = "name no puede estar vacío")
    private String name;

    private String description;

}