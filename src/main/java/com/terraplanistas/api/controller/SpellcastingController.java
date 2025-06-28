package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.DTO.SpellcastingCreateDTO;
import com.terraplanistas.api.model.Class;
import com.terraplanistas.api.model.Spellcasting;
import com.terraplanistas.api.service.ClassService;
import com.terraplanistas.api.service.SpellcastingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/spellcasting")
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

    @Autowired
    private ClassService classService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody SpellcastingCreateDTO spellcastingCreateDTO) {
        Class clazz;
        try {
            clazz = classService.findById(UUID.fromString(spellcastingCreateDTO.getClassId()));
            if (clazz == null) {
                return ResponseEntity.badRequest().body("La clase con ID " + spellcastingCreateDTO.getClassId() + " no existe.");
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al encontrar la clase: " + e.getMessage());
        }

        Spellcasting spellcasting = new Spellcasting();
        spellcasting.setClazz(clazz);
        spellcasting.setSpellcastingProgressionEnum(spellcastingCreateDTO.getSpellcastingProgressionEnum());
        spellcasting.setSpellcastingAbility(spellcastingCreateDTO.getSpellcastingAbility());
        spellcasting.setPreparationFormula(spellcastingCreateDTO.getPreparationFormula());

        try {
            Spellcasting savedSpellcasting = spellcastingService.save(spellcasting);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedSpellcasting);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar el lanzamiento de conjuros: " + e.getMessage());
        }
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
