package com.terraplanistas.api.controller;

import com.terraplanistas.api.service.CharacterService;
import com.terraplanistas.api.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping
    public List<Character> findAll() {
        return characterService.findAll();
    }

    @GetMapping("/{id}")
    public Character findById(@PathVariable UUID id) {
        return characterService.findById(id);
    }

    @PostMapping
    public Character save(@RequestBody Character character) {
        return characterService.save(character);
    }

    @PutMapping
    public Character update(@RequestBody Character character) {
        return characterService.update(character);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        characterService.deleteById(id);
    }


}
