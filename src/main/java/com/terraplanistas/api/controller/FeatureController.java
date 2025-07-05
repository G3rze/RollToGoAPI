package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.requestDTO.FeatureCreateDTO;
import com.terraplanistas.api.model.Content;
import com.terraplanistas.api.model.Feature;
import com.terraplanistas.api.service.ContentService;
import com.terraplanistas.api.service.FeatureService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/features")
public class FeatureController {

    @Autowired
    private FeatureService featureService;

    @GetMapping
    public List<Feature> findAll() {
        return featureService.findAll();
    }

    @GetMapping("/{id}")
    public Feature findById(@PathVariable UUID id) {
        return featureService.findById(id);
    }

    @Autowired
    private ContentService contentService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody FeatureCreateDTO featureCreateDTO) {
        Content content;
        try {
            UUID contentUuid = UUID.fromString(featureCreateDTO.getContentId());
            content = contentService.findById(contentUuid);

            if (content == null) {
                return ResponseEntity.badRequest().body("El contenido con ID " + featureCreateDTO.getContentId() + " no existe.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("El ID de contenido proporcionado no es un formato UUID válido: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al encontrar el contenido: " + e.getMessage());
        }

        Feature feature = new Feature();
        feature.setContent(content);
        feature.setName(featureCreateDTO.getName());
        feature.setDescription(featureCreateDTO.getDescription());
        feature.setMagic(featureCreateDTO.getIsMagic());
        feature.setPassive(featureCreateDTO.getIsPassive());

        try {
            Feature savedFeature = featureService.save(feature);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedFeature);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar la característica: " + e.getMessage());
        }
    }

    @PutMapping
    public Feature update(@RequestBody Feature feature) {
        return featureService.update(feature);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        featureService.deleteById(id);
    }

}
