package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.Proficiency;
import com.terraplanistas.api.service.ProficiencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/proficiencies")
public class ProficiencyController {

    @Autowired
    private ProficiencyService proficiencyService;

    @GetMapping
    public List<Proficiency> findAll() {
        return proficiencyService.findAll();
    }

    @GetMapping("/{id}")
    public Proficiency findById(@PathVariable UUID id) {
        return proficiencyService.findById(id);
    }

    @PostMapping
    public Proficiency save(@RequestBody Proficiency proficiency) {
        return proficiencyService.save(proficiency);
    }

    @PutMapping
    public Proficiency update(@RequestBody Proficiency proficiency) {
        return proficiencyService.update(proficiency);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        proficiencyService.deleteById(id);
    }

}
