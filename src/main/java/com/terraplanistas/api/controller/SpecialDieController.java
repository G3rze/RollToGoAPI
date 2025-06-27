package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.DTO.SpecialDieCreateDTO;
import com.terraplanistas.api.model.Feature;
import com.terraplanistas.api.model.SpecialDie;
import com.terraplanistas.api.service.FeatureService;
import com.terraplanistas.api.service.SpecialDieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/special-dice")
public class SpecialDieController {

    @Autowired
    private SpecialDieService specialDieService;

    @GetMapping
    public List<SpecialDie> findAll() {
        return specialDieService.findAll();
    }

    @GetMapping("/{id}")
    public SpecialDie findById(@PathVariable UUID id) {
        return specialDieService.findById(id);
    }

    @Autowired
    private FeatureService featureService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody SpecialDieCreateDTO specialDieCreateDTO) {
        Feature feature;
        try {
            feature = featureService.findById(specialDieCreateDTO.getFeatureId());

            if (feature == null) {
                return ResponseEntity.badRequest().body("La característica con ID " + specialDieCreateDTO.getFeatureId() + " no existe.");
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al encontrar la característica: " + e.getMessage());
        }

        SpecialDie specialDie = new SpecialDie();
        specialDie.setFeature(feature);
        specialDie.setName(specialDieCreateDTO.getName());
        specialDie.setQuantity(specialDieCreateDTO.getQuantity());
        specialDie.setDieFormula(specialDieCreateDTO.getDieFormula());

        try {
            SpecialDie savedSpecialDie = specialDieService.save(specialDie);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedSpecialDie);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar el dado especial: " + e.getMessage());
        }
    }

    @PutMapping
    public SpecialDie update(@RequestBody SpecialDie specialDie) {
        return specialDieService.update(specialDie);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        specialDieService.deleteById(id);
    }

}
