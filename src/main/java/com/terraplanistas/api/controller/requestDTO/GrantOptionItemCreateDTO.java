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
public class GrantOptionItemCreateDTO {
    @NotBlank(message = "El ID del conjunto de opciones otorgante no puede ser nulo")
    private String granterOptionSetId;

    @NotBlank(message = "El ID del contenido otorgado no puede ser nulo")
    private String grantedContentId;
}