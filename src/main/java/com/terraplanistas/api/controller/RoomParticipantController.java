package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.RoomParticipant;
import com.terraplanistas.api.service.RoomParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/room-participants")
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


    @PostMapping
    public RoomParticipant save(@RequestBody RoomParticipant roomParticipant) {
        return roomParticipantService.save(roomParticipant);
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
