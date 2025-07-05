package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.requestDTO.RoomParticipantCreateDTO;
import com.terraplanistas.api.model.Room;
import com.terraplanistas.api.model.RoomParticipant;
import com.terraplanistas.api.model.User;
import com.terraplanistas.api.service.RoomParticipantService;
import com.terraplanistas.api.service.RoomService;
import com.terraplanistas.api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/room-participants")
public class RoomParticipantController {

    @Autowired
    private RoomParticipantService roomParticipantService;

    @GetMapping
    public List<RoomParticipant> findAll() {
        return roomParticipantService.findAll();
    }

    @GetMapping("/{id}")
    public RoomParticipant findById(UUID id) {
        return roomParticipantService.findById(id);
    }


    @Autowired
    private RoomService roomService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody RoomParticipantCreateDTO roomParticipantCreateDTO) {
        Room room;
        User user;
        try {
            UUID roomUuid = UUID.fromString(roomParticipantCreateDTO.getRoomId());
            Room roomOptional = roomService.findById(roomUuid);
            if (roomOptional == null) {
                return ResponseEntity.badRequest().body("La sala con ID " + roomParticipantCreateDTO.getRoomId() + " no existe.");
            }
            room = roomOptional;
            User userOptional = userService.findById(roomParticipantCreateDTO.getUserId());
            if (userOptional == null) {
                return ResponseEntity.badRequest().body("El usuario con ID " + roomParticipantCreateDTO.getUserId() + " no existe.");
            }
            user = userOptional;
            Optional<RoomParticipant> existingParticipant = roomParticipantService.findByRoomAndUser(room, user);
            if (existingParticipant.isPresent()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("El usuario con ID " + roomParticipantCreateDTO.getUserId() + " ya es participante de la sala con ID " + roomParticipantCreateDTO.getRoomId() + ".");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Uno de los IDs proporcionados no es un formato UUID válido: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al encontrar la sala o el usuario: " + e.getMessage());
        }

        RoomParticipant roomParticipant = new RoomParticipant();
        roomParticipant.setRoom(room);
        roomParticipant.setUser(user);
        roomParticipant.setRoleEnum(roomParticipantCreateDTO.getRoleEnum());

        try {
            RoomParticipant savedRoomParticipant = roomParticipantService.save(roomParticipant);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedRoomParticipant);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar el participante de la sala: " + e.getMessage());
        }
    }


    @PutMapping
    public RoomParticipant update(@RequestBody RoomParticipant roomParticipant) {
        return roomParticipantService.update(roomParticipant);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        roomParticipantService.deleteById(id);
    }

}
