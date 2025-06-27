package com.terraplanistas.api.controller.DTO;

import com.terraplanistas.api.model.enums.RoleEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class RoomParticipantCreateDTO {
    @NotEmpty(message = "room id es necesario")
    private String roomId;

    @NotEmpty(message = "user id es necesario")
    private String userId;

    @NotNull(message = "rol es necesario")
    private RoleEnum roleEnum;
}
