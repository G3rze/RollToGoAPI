package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.DTO.SubspeciesCreateDTO;
import com.terraplanistas.api.model.Content;
import com.terraplanistas.api.model.Species;
import com.terraplanistas.api.model.Subspecies;
import com.terraplanistas.api.service.ContentService;
import com.terraplanistas.api.service.SpeciesService;
import com.terraplanistas.api.service.SubspeciesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/subspecies")
public class SubspeciesController {

    @Autowired
    private SubspeciesService subspeciesService;

    @GetMapping
    public List<Subspecies> findAll() {
        return subspeciesService.findAll();
    }

    @GetMapping("/{id}")
    public Subspecies findById(@PathVariable UUID id) {
        return subspeciesService.findById(id);
    }

    @Autowired
    private ContentService contentService;

    @Autowired
    private SpeciesService speciesService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody SubspeciesCreateDTO subspeciesCreateDTO) {
        Content content;
        Species species;

        try {
            UUID contentUuid = UUID.fromString(subspeciesCreateDTO.getContentId());
            content = contentService.findById(contentUuid);
            if (content == null) {
                return ResponseEntity.badRequest().body("El contenido con ID " + subspeciesCreateDTO.getContentId() + " no existe.");
            }
            UUID speciesUuid = UUID.fromString(subspeciesCreateDTO.getSpeciesId());
            species = speciesService.findById(speciesUuid);
            if (species == null) {
                return ResponseEntity.badRequest().body("La especie con ID " + subspeciesCreateDTO.getSpeciesId() + " no existe.");
            }

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Uno de los IDs proporcionados no es un formato UUID válido: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al encontrar las entidades relacionadas (contenido o especie): " + e.getMessage());
        }

        Subspecies subspecies = new Subspecies();
        subspecies.setContent(content);
        subspecies.setSpecies(species);
        subspecies.setName(subspeciesCreateDTO.getName());
        subspecies.setDescription(subspeciesCreateDTO.getDescription());
        subspecies.setLanguages(subspeciesCreateDTO.getLanguages());
        subspecies.setSizeEnum(subspeciesCreateDTO.getSizeEnum());

        try {
            Subspecies savedSubspecies = subspeciesService.save(subspecies);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedSubspecies);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar la subespecie: " + e.getMessage());
        }
    }

    @PutMapping
    public Subspecies update(@RequestBody Subspecies subspecies) {
        return subspeciesService.update(subspecies);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        subspeciesService.deleteById(id);
    }

}
