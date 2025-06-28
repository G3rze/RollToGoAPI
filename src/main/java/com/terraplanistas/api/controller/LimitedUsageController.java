package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.DTO.LimitedUsageCreateDTO;
import com.terraplanistas.api.model.Content;
import com.terraplanistas.api.model.LimitedUsage;
import com.terraplanistas.api.service.ContentService;
import com.terraplanistas.api.service.LimitedUsageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/limited-usage")
public class LimitedUsageController {

    @Autowired
    private LimitedUsageService limitedUsageService;

    @GetMapping
    public List<LimitedUsage> findAll() {
        return limitedUsageService.findAll();
    }

    @GetMapping("/{id}")
    public LimitedUsage findById(@PathVariable UUID id) {
        return limitedUsageService.findById(id);
    }


    @Autowired
    private ContentService contentService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody LimitedUsageCreateDTO limitedUsageCreateDTO) {
        Content content;
        try {
            UUID contentUuid = UUID.fromString(limitedUsageCreateDTO.getContentId());
            content = contentService.findById(contentUuid);
            if (content == null) {
                return ResponseEntity.badRequest().body("El contenido con ID " + limitedUsageCreateDTO.getContentId() + " no existe.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("El ID de contenido proporcionado no es un formato UUID válido: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al encontrar el contenido: " + e.getMessage());
        }

        LimitedUsage limitedUsage = new LimitedUsage();
        limitedUsage.setContent(content);
        limitedUsage.setBaseMaxUsesFormula(limitedUsageCreateDTO.getBaseMaxUsesFormula());
        limitedUsage.setScaling(limitedUsageCreateDTO.getIsScaling());
        limitedUsage.setUses(limitedUsageCreateDTO.getUses());
        limitedUsage.setScalingFormula(limitedUsageCreateDTO.getScalingFormula());
        limitedUsage.setRecoveryTypeEnum(limitedUsageCreateDTO.getRecoveryTypeEnum());

        try {
            LimitedUsage savedLimitedUsage = limitedUsageService.save(limitedUsage);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedLimitedUsage);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar el uso limitado: " + e.getMessage());
        }
    }

    @PutMapping
    public LimitedUsage update(@RequestBody LimitedUsage limitedUsage) {
        return limitedUsageService.update(limitedUsage);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        limitedUsageService.deleteById(id);
    }




}
