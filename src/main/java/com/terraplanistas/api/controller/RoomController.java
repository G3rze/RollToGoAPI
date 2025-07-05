package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.requestDTO.RoomCreateDTO;
import com.terraplanistas.api.model.Content;
import com.terraplanistas.api.model.Room;
import com.terraplanistas.api.service.ContentService;
import com.terraplanistas.api.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private ContentService contentService;


    @GetMapping
    public List<Room> findAll() {
        return roomService.findAll();
    }

    @GetMapping("/{id}")
    public Room findById(@PathVariable UUID id) {
        return roomService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody RoomCreateDTO roomDTO) {
        if (roomDTO.getContentId() == null) {
            return ResponseEntity.badRequest().body("contentId es requerido");
        }

        Optional<Content> content = Optional.ofNullable(contentService.findById(UUID.fromString(roomDTO.getContentId())));
        if (content.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Content no encontrado con ID: " + roomDTO.getContentId());
        }

        Room room = new Room();
        room.setName(roomDTO.getName());
        room.setDescription(roomDTO.getDescription());
        room.setContent(content.get());

        try {
            Room savedRoom = roomService.save(room);
            return ResponseEntity.ok(savedRoom);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error al crear la room: " + e.getMessage());
        }
    }

    @PutMapping
    public Room update(@RequestBody Room room) {
        return roomService.update(room);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        roomService.deleteById(id);
    }

}
