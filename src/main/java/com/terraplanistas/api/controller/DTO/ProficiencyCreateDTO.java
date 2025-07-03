package com.terraplanistas.api.controller.DTO;

import com.terraplanistas.api.model.enums.ProficiencyTypeEnum;
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
public class ProficiencyCreateDTO {
    @NotBlank(message = "El ID de contenido no puede estar vacío")
    private String contentId;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    @NotNull(message = "El tipo de competencia no puede ser nulo")
    private ProficiencyTypeEnum proficiencyTypeEnum;
}
