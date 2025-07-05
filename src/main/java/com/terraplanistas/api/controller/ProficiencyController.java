package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.requestDTO.ProficiencyCreateDTO;
import com.terraplanistas.api.model.Content;
import com.terraplanistas.api.model.Proficiency;
import com.terraplanistas.api.service.ContentService;
import com.terraplanistas.api.service.ProficiencyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/proficiencies")
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

    @Autowired
    private ContentService contentService;
    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ProficiencyCreateDTO proficiencyCreateDTO) {
        Content content;
        try {
            UUID contentUuid = UUID.fromString(proficiencyCreateDTO.getContentId());
            content = contentService.findById(contentUuid);

            if (content == null) {
                return ResponseEntity.badRequest().body("El contenido con ID " + proficiencyCreateDTO.getContentId() + " no existe.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("El ID de contenido proporcionado no es un formato UUID válido: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al encontrar el contenido: " + e.getMessage());
        }

        Proficiency proficiency = new Proficiency();
        proficiency.setContent(content);
        proficiency.setName(proficiencyCreateDTO.getName());
        proficiency.setProficiencyTypeEnum(proficiencyCreateDTO.getProficiencyTypeEnum());

        try {
            Proficiency savedProficiency = proficiencyService.save(proficiency);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedProficiency);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar la competencia: " + e.getMessage());
        }
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
