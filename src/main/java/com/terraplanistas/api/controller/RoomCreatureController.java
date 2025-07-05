package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.requestDTO.RoomCreatureCreateDTO;
import com.terraplanistas.api.model.Creature;
import com.terraplanistas.api.model.Room;
import com.terraplanistas.api.model.RoomCreature;
import com.terraplanistas.api.model.User;
import com.terraplanistas.api.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/room-creature")
public class RoomCreatureController {

    @Autowired
    private RoomCreatureService roomCreatureService;

    @GetMapping
    public List<RoomCreature> findAll() {
        return roomCreatureService.findAll();
    }

    @GetMapping("/{id}")
    public RoomCreature findById(@PathVariable UUID id) {
        return roomCreatureService.findById(id);
    }

    @Autowired
    private UserService userService;

    @Autowired
    private RoomService roomService;
    @Autowired
    private ContentService contentService;
    @Autowired
    private CreatureService creatureService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody RoomCreatureCreateDTO roomCreatureCreateDTO) {
        Creature creature;
        User owner;
        Room room;
        try {
            UUID creatureUuid = UUID.fromString(roomCreatureCreateDTO.getCreatureId());
            creature = creatureService.findById(creatureUuid);
            if (creature == null) {
                return ResponseEntity.badRequest().body("La criatura con ID " + roomCreatureCreateDTO.getCreatureId() + " no existe.");
            }
            UUID ownerUuid = UUID.fromString(roomCreatureCreateDTO.getOwnerId());
            owner = userService.findById(String.valueOf(ownerUuid));
            if (owner == null) {
                return ResponseEntity.badRequest().body("El propietario con ID " + roomCreatureCreateDTO.getOwnerId() + " no existe.");
            }
            UUID roomUuid = UUID.fromString(roomCreatureCreateDTO.getRoomId());
            room = roomService.findById(roomUuid);
            if (room == null) {
                return ResponseEntity.badRequest().body("La sala con ID " + roomCreatureCreateDTO.getRoomId() + " no existe.");
            }

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Uno de los IDs proporcionados no es un formato UUID válido: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al encontrar las entidades relacionadas: " + e.getMessage());
        }

        RoomCreature roomCreature = new RoomCreature();
        roomCreature.setCreature(creature);
        roomCreature.setOwner(owner);
        roomCreature.setRoom(room);
        roomCreature.setCreatureType(roomCreatureCreateDTO.getCreatureType());

        try {
            RoomCreature savedRoomCreature = roomCreatureService.save(roomCreature);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedRoomCreature);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar la criatura de la sala: " + e.getMessage());
        }
    }

    @PutMapping
    public RoomCreature update(@RequestBody RoomCreature roomCreature) {
        return roomCreatureService.update(roomCreature);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        roomCreatureService.deleteById(id);
    }

}
