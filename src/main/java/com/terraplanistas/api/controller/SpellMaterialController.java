package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.SpellMaterial;
import com.terraplanistas.api.service.SpellMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/spell-material")
public class SpellMaterialController {

    @Autowired
    private SpellMaterialService spellMaterialService;

    @GetMapping
    public List<SpellMaterial> findAll() {
        return spellMaterialService.findAll();
    }

    @GetMapping("/{id}")
    public SpellMaterial findById(@PathVariable UUID id) {
        return spellMaterialService.findById(id);
    }

    @PostMapping
    public SpellMaterial save(@RequestBody SpellMaterial spellMaterial) {
        return spellMaterialService.save(spellMaterial);
    }

    @PutMapping
    public SpellMaterial update(@RequestBody SpellMaterial spellMaterial) {
        return spellMaterialService.update(spellMaterial);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        spellMaterialService.deleteById(id);
    }


}
