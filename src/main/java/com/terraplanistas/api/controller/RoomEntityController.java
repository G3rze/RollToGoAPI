package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.RoomEntity;
import com.terraplanistas.api.service.RoomEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/room-entity")
public class RoomEntityController {

    @Autowired
    private RoomEntityService roomEntityService;

    @GetMapping
    public List<RoomEntity> getAllRoomEntity() {
        return roomEntityService.findAll();
    }

    @GetMapping("/{id}")
    public RoomEntity getRoomEntityById(@PathVariable UUID id) {
        return roomEntityService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "RoomEntity not found with id: " + id));
    }

    @PostMapping
    public RoomEntity createRoomEntity(@RequestBody RoomEntity RoomEntity) {
        return roomEntityService.save(RoomEntity);
    }

    @PutMapping("/{id}")
    public RoomEntity updateRoomEntity(@PathVariable UUID id, @RequestBody RoomEntity RoomEntity) {
        if (roomEntityService.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "RoomEntity not found with id: " + id);
        }
        return roomEntityService.save(RoomEntity);
    }

    @DeleteMapping
    public void deleteRoomEntity(@RequestBody UUID id) {
        roomEntityService.deleteById(id);
    }
}
