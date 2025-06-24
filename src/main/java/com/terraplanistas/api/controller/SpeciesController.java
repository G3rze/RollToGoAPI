package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.Species;
import com.terraplanistas.api.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/species")
public class SpeciesController {

    @Autowired
    private SpeciesService speciesService;

    @GetMapping
    public List<Species> findAll() {
        return speciesService.findAll();
    }

    @GetMapping("/{id}")
    public Species findById(@PathVariable UUID id) {
        return speciesService.findById(id);
    }

    @PostMapping
    public Species save(@RequestBody Species species) {
        return speciesService.save(species);
    }

    @PutMapping
    public Species update(@RequestBody Species species) {
        return speciesService.update(species);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        speciesService.deleteById(id);
    }

}
