package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.LevelProgression;
import com.terraplanistas.api.service.LevelProgressionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/level-progressions")
public class LevelProgressionController {

    @Autowired
    private LevelProgressionService levelProgressionService;

    @GetMapping
    public List<LevelProgression> findAll() {
        return levelProgressionService.findAll();
    }

    @GetMapping("/{id}")
    public LevelProgression findById(@PathVariable UUID id) {
        return levelProgressionService.findById(id);
    }

    @PostMapping
    public LevelProgression save(@RequestBody LevelProgression levelProgression) {
        return levelProgressionService.save(levelProgression);
    }

    @PutMapping
    public LevelProgression update(@RequestBody LevelProgression levelProgression) {
        return levelProgressionService.update(levelProgression);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        levelProgressionService.deleteById(id);
    }


}
