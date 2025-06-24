package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.Spellcasting;
import com.terraplanistas.api.service.SpellcastingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/spellcasting")
public class SpellcastingController {

    @Autowired
    private SpellcastingService spellcastingService;

    @GetMapping
    public List<Spellcasting> findAll() {
        return spellcastingService.findAll();
    }

    @GetMapping("/{id}")
    public Spellcasting findById(@PathVariable UUID id) {
        return spellcastingService.findById(id);
    }

    @PostMapping
    public Spellcasting save(@RequestBody Spellcasting spellcasting) {
        return spellcastingService.save(spellcasting);
    }

    @PutMapping
    public Spellcasting update(@RequestBody Spellcasting spellcasting) {
        return spellcastingService.update(spellcasting);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        spellcastingService.deleteById(id);
    }
}
