package com.terraplanistas.api.controller.requestDTO;

import com.terraplanistas.api.model.enums.SourceContentEnum;
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
public class GrantCreateDTO {
    @NotNull(message = "El tipo de otorgante no puede ser nulo")
    private SourceContentEnum granterType;

    @NotBlank(message = "El ID del contenido otorgante no puede ser nulo")
    private String granterContentId;

    @NotNull(message = "El tipo de contenido concedido no puede ser nulo")
    private SourceContentEnum grantedType;

    @NotBlank(message = "El ID del contenido concedido no puede ser nulo")
    private String grantedContentId;
}