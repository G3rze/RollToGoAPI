package com.terraplanistas.api.controller.DTO;

import com.terraplanistas.api.model.enums.SourceContentEnum;
import com.terraplanistas.api.model.enums.VisibilityEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ContentCreateDTO {
    @NotNull(message = "El tipo de contenido fuente no puede ser nulo")
    private SourceContentEnum sourceContentEnum;

    @NotNull(message = "La visibilidad no puede ser nula")
    private VisibilityEnum visibilityEnum;
    @NotNull(message = "El ID del autor no puede ser nulo")
    private String authorId;
}
