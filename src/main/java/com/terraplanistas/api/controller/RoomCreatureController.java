package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.RoomCreature;
import com.terraplanistas.api.service.RoomCreatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/room-creature")
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

    @PostMapping
    public RoomCreature save(@RequestBody RoomCreature roomCreature) {
        return roomCreatureService.save(roomCreature);
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
