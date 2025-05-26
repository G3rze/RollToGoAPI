package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.RoomChat;
import com.terraplanistas.api.service.RoomChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/room-chat")
public class RoomChatController {

    @Autowired
    private RoomChatService roomChatService;

    @GetMapping
    public List<RoomChat> getAllRoomChat() {
        return roomChatService.findAll();
    }

    @GetMapping("/{id}")
    public RoomChat getRoomChatById(@PathVariable UUID id) {
        return roomChatService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "RoomChat not found with id: " + id));
    }

    @PostMapping
    public RoomChat createRoomChat(@RequestBody RoomChat RoomChat) {
        return roomChatService.save(RoomChat);
    }

    @PutMapping("/{id}")
    public RoomChat updateRoomChat(@PathVariable UUID id, @RequestBody RoomChat RoomChat) {
        if (roomChatService.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "RoomChat not found with id: " + id);
        }
        return roomChatService.save(RoomChat);
    }

    @DeleteMapping
    public void deleteRoomChat(@RequestBody UUID id) {
        roomChatService.deleteById(id);
    }
}
