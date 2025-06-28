package com.terraplanistas.api.test;

import com.terraplanistas.api.controller.DTO.RoomCreateDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class RoomControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void whenValidInput_thenReturns200() throws Exception {
        String contentId = "fd3a7139-27ee-4f27-8e3b-86550c062a07";
        String requestJson = objectMapper.writeValueAsString(new RoomCreateDTO(
                contentId, "Sala Test", "Descripción Test"));

        mockMvc.perform(post("/api/room")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    void whenEmptyName_thenReturns400() throws Exception {
        String contentId = "fd3a7139-27ee-4f27-8e3b-86550c062a07";
        String requestJson = objectMapper.writeValueAsString(new RoomCreateDTO(
                contentId, "", "Descripción Test"));

        mockMvc.perform(post("/api/room")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("name no puede estar vacío"));
    }

    @Test
    void whenNullContentId_thenReturns400() throws Exception {
        String requestJson = objectMapper.writeValueAsString(new RoomCreateDTO(
                null, "Sala Test", "Descripción Test"));

        mockMvc.perform(post("/api/room")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.contentId").value("contentId es requerido"));
    }
}