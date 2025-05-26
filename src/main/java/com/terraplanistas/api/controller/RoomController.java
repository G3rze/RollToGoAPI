package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.Room;
import com.terraplanistas.api.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<Room> getAllRoom() {
        return roomService.findAll();
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable UUID id) {
        return roomService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found with id: " + id));
    }

    @PostMapping
    public Room createRoom(@RequestBody Room Room) {
        return roomService.save(Room);
    }

    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable UUID id, @RequestBody Room Room) {
        if (roomService.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found with id: " + id);
        }
        return roomService.save(Room);
    }

    @DeleteMapping
    public void deleteRoom(@RequestBody UUID id) {
        roomService.deleteById(id);
    }
}
