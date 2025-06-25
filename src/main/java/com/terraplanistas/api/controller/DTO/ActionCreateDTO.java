package com.terraplanistas.api.controller.DTO;

import com.terraplanistas.api.model.enums.AbilityTypeEnum;
import com.terraplanistas.api.model.enums.ActionTypeEnum;
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
public class ActionCreateDTO {
    @NotBlank(message = "Content ID no puede ser vacío")
    private String contentId;

    @NotNull(message = "Action Type no puede ser nulo")
    private ActionTypeEnum actionType;

    private String attackFormula;

    private AbilityTypeEnum saveAbilityType;

    private String saveDcFormula;

    private Boolean isRolled;
}