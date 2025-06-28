package com.terraplanistas.api.controller.DTO;

import com.terraplanistas.api.model.enums.CurrencyEnum;
import com.terraplanistas.api.model.enums.ItemTypeEnum;
import com.terraplanistas.api.model.enums.RarityEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ItemCreateDTO {
    @NotBlank(message = "El ID de contenido no puede estar vacío")
    private String contentId;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    private String description;

    @NotNull(message = "El tipo de ítem no puede ser nulo")
    private ItemTypeEnum itemTypeEnum;

    @NotNull(message = "La rareza no puede ser nula")
    private RarityEnum rarityEnum;

    @NotNull(message = "El peso no puede ser nulo")
    @DecimalMin(value = "0.0", message = "El peso no puede ser negativo")
    private Double weight;

    @NotNull(message = "El valor del costo no puede ser nulo")
    @DecimalMin(value = "0.0", message = "El valor del costo no puede ser negativo")
    private Double costValue;

    @NotNull(message = "La moneda del costo no puede ser nula")
    private CurrencyEnum costCurrency;

    private Boolean attunementRequired;

    private Boolean isMagic;

}
