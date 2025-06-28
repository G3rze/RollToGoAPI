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
public class ChatMessageCreateDTO {
    @NotNull(message = "El ID de la sala no puede ser nulo")
    private String roomId;

    private String sender;

    @NotBlank(message = "El contenido no puede estar vacío")
    private String content;
}
