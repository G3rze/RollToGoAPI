package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.CharacterLevelProgression;
import com.terraplanistas.api.service.CharacterLevelProgressionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/character-level-progression")
public class CharacterLevelProgressionController {

    @Autowired
    private CharacterLevelProgressionService characterLevelProgressionService;

    @GetMapping
    public List<CharacterLevelProgression> getAllCharacterLevelProgressions() {
        return characterLevelProgressionService.findAll();
    }

    @GetMapping("/{id}")
    public CharacterLevelProgression getCharacterLevelProgressionById(@PathVariable UUID id) {
        return characterLevelProgressionService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CharacterLevelProgression not found with id: " + id));
    }

    @PostMapping
    public CharacterLevelProgression createCharacterLevelProgression(@RequestBody CharacterLevelProgression characterLevelProgression) {
        return characterLevelProgressionService.save(characterLevelProgression);
    }

    @PutMapping("/{id}")
    public CharacterLevelProgression updateCharacterLevelProgression(@PathVariable UUID id, @RequestBody CharacterLevelProgression characterLevelProgression) {
        if (characterLevelProgressionService.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CharacterLevelProgression not found with id: " + id);
        }
        return characterLevelProgressionService.save(characterLevelProgression);
    }
}