package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.RoomParticipant;
import com.terraplanistas.api.service.RoomParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/room-participant")
public class RoomParticipantController {

    @Autowired
    private RoomParticipantService roomParticipantService;

    @GetMapping
    public List<RoomParticipant> getAllRoomParticipant() {
        return roomParticipantService.findAll();
    }

    @GetMapping("/{id}")
    public RoomParticipant getRoomParticipantById(@PathVariable UUID id) {
        return roomParticipantService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "RoomParticipant not found with id: " + id));
    }

    @PostMapping
    public RoomParticipant createRoomParticipant(@RequestBody RoomParticipant RoomParticipant) {
        return roomParticipantService.save(RoomParticipant);
    }

    @PutMapping("/{id}")
    public RoomParticipant updateRoomParticipant(@PathVariable UUID id, @RequestBody RoomParticipant roomParticipant) {
        if (roomParticipantService.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "RoomParticipant not found with id: " + id);
        }
        return roomParticipantService.save(roomParticipant);
    }

    @DeleteMapping
    public void deleteRoomParticipant(@RequestBody UUID id) {
        roomParticipantService.deleteById(id);
    }
}
