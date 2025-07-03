package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.DTO.DamageCreateDTO;
import com.terraplanistas.api.model.Content;
import com.terraplanistas.api.model.Damage;
import com.terraplanistas.api.repository.DamageRepository;
import com.terraplanistas.api.service.ContentService;
import com.terraplanistas.api.service.DamageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/damage")
public class DamageController {

    @Autowired
    private DamageService damageService;
    @Autowired
    private ContentService contentService;

    @GetMapping
    public List<Damage> findAll() {
        return damageService.findAll();
    }

    @GetMapping("/{id}")
    public Damage findById(@PathVariable UUID id){
        return damageService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody DamageCreateDTO damageCreateDTO) {
        Content content;
        try {
            UUID contentUuid = UUID.fromString(damageCreateDTO.getContentId());
            content = contentService.findById(contentUuid);
            if (content == null) {
                return ResponseEntity.badRequest().body("El contenido con ID " + damageCreateDTO.getContentId() + " no existe.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("El ID de contenido proporcionado no es un formato UUID válido: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al encontrar el contenido: " + e.getMessage());
        }
        Damage damage = new Damage();
        damage.setContent(content);
        damage.setDamageFormula(damageCreateDTO.getDamageFormula());
        damage.setDamageTypeEnum(damageCreateDTO.getDamageTypeEnum());
        damage.setRepeat(damageCreateDTO.getRepeat());
        damage.setRepeatTimeValue(damageCreateDTO.getRepeatTimeValue());
        damage.setRepeatTimeUnit(damageCreateDTO.getRepeatTimeUnit());
        damage.setContent(content);

        try {
            Damage savedDamage = damageService.save(damage);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedDamage);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar el daño: " + e.getMessage());
        }
    }

    @PutMapping
    public Damage update(@RequestBody Damage damage) {
        return damageService.update(damage);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        damageService.deleteById(id);
    }
}
