package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.DTO.LevelProgressionCreateDTO;
import com.terraplanistas.api.model.Content;
import com.terraplanistas.api.model.LevelProgression;
import com.terraplanistas.api.service.ContentService;
import com.terraplanistas.api.service.LevelProgressionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/level-progressions")
public class LevelProgressionController {

    @Autowired
    private LevelProgressionService levelProgressionService;
    @Autowired
    ContentService contentService;

    @GetMapping
    public List<LevelProgression> findAll() {
        return levelProgressionService.findAll();
    }

    @GetMapping("/{id}")
    public LevelProgression findById(@PathVariable UUID id) {
        return levelProgressionService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody LevelProgressionCreateDTO levelProgressionCreateDTO) {
        Content content;
        try {
            UUID contentUuid = UUID.fromString(levelProgressionCreateDTO.getContentId());
            content = contentService.findById(contentUuid);
            if (content == null) {
                return ResponseEntity.badRequest().body("El contenido con ID " + levelProgressionCreateDTO.getContentId() + " no existe.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("El ID de contenido proporcionado no es un formato UUID válido: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al encontrar el contenido: " + e.getMessage());
        }

        LevelProgression levelProgression = new LevelProgression();
        levelProgression.setContent(content);
        levelProgression.setLevel(levelProgressionCreateDTO.getLevel());
        levelProgression.setNewSpecialValue(levelProgressionCreateDTO.getNewSpecialValue());
        levelProgression.setNewSpecialDieFormula(levelProgressionCreateDTO.getNewSpecialDieFormula());

        try {
            LevelProgression savedLevelProgression = levelProgressionService.save(levelProgression);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedLevelProgression);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar la progresión de nivel: " + e.getMessage());
        }
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
