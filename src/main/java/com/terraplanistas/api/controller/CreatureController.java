package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.Creature;
import com.terraplanistas.api.service.CreatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/creatures")
public class CreatureController {

    @Autowired
    private CreatureService creatureService;

    @GetMapping
    public List<Creature> findAll() {
        return creatureService.findAll();
    }

    @GetMapping("/{id}")
    public Creature findById(@PathVariable UUID id) {
        return creatureService.findById(id);
    }

    @PostMapping
    public Creature save(@RequestBody Creature creature) {
        return creatureService.save(creature);
    }

    @PutMapping
    public Creature update(@RequestBody Creature creature) {
        return creatureService.update(creature);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        creatureService.deleteById(id);
    }

}
