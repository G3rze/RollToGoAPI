package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.requestDTO.SpeciesCreateDTO;
import com.terraplanistas.api.model.Content;
import com.terraplanistas.api.model.Species;
import com.terraplanistas.api.service.ContentService;
import com.terraplanistas.api.service.SpeciesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/species")
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

    @Autowired
    private ContentService contentService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody SpeciesCreateDTO speciesCreateDTO) {
        Content content;
        try {
            UUID contentUuid = UUID.fromString(speciesCreateDTO.getContentId());
            content = contentService.findById(contentUuid);
            if (content == null) {
                return ResponseEntity.badRequest().body("El contenido con ID " + speciesCreateDTO.getContentId() + " no existe.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("El ID de contenido proporcionado no es un formato UUID válido: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al encontrar el contenido: " + e.getMessage());
        }

        Species species = new Species();
        species.setContent(content);
        species.setName(speciesCreateDTO.getName());
        species.setDescription(speciesCreateDTO.getDescription());
        species.setCreatureTypeEnum(speciesCreateDTO.getCreatureTypeEnum());
        species.setLanguages(speciesCreateDTO.getLanguages());
        species.setSizeEnum(speciesCreateDTO.getSizeEnum());

        try {
            Species savedSpecies = speciesService.save(species);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedSpecies);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar la especie: " + e.getMessage());
        }
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
