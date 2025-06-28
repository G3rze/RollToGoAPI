package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.DTO.FeatCreateDTO;
import com.terraplanistas.api.model.Content;
import com.terraplanistas.api.model.Feat;
import com.terraplanistas.api.service.ContentService;
import com.terraplanistas.api.service.FeatService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/feats")
public class FeatController {

    @Autowired
    private FeatService featService;

    @GetMapping
    public List<Feat> findAll() {
        return featService.findAll();
    }

    @GetMapping("/{id}")
    public Feat findById(@PathVariable UUID id) {
        return featService.findById(id);
    }

    @Autowired
    private ContentService contentService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody FeatCreateDTO featCreateDTO) {
        Content content;
        try {
            UUID contentUuid = UUID.fromString(featCreateDTO.getContentId());
            content = contentService.findById(contentUuid);

            if (content == null) {
                return ResponseEntity.badRequest().body("El contenido con ID " + featCreateDTO.getContentId() + " no existe.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("El ID de contenido proporcionado no es un formato UUID válido: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al encontrar el contenido: " + e.getMessage());
        }

        Feat feat = new Feat();
        feat.setContent(content);
        feat.setName(featCreateDTO.getName());
        feat.setDescription(featCreateDTO.getDescription());

        try {
            Feat savedFeat = featService.save(feat);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedFeat);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar la hazaña: " + e.getMessage());
        }
    }

    @PutMapping
    public Feat update(@RequestBody Feat feat) {
        return featService.update(feat);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        featService.deleteById(id);
    }

}
