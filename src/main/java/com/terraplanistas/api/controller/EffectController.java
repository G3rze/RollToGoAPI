package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.DTO.EffectCreateDTO;
import com.terraplanistas.api.model.Content;
import com.terraplanistas.api.model.Effect;
import com.terraplanistas.api.service.ContentService;
import com.terraplanistas.api.service.EffectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/effects")
public class EffectController {

    @Autowired
    private EffectService effectService;
    @Autowired
    private ContentService contentService;

    @GetMapping
    public List<Effect> findAll() {
        return effectService.findAll();
    }

    @GetMapping("/{id}")
    public Effect findById(@PathVariable UUID id) {
        return effectService.findById(id);
    }


    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody EffectCreateDTO effectCreateDTO) {
        Content content;
        try {
            UUID contentUuid = UUID.fromString(effectCreateDTO.getContentId());
            content = contentService.findById(contentUuid);

            if (content == null) {
                return ResponseEntity.badRequest().body("no se encontró contenido con el id " + effectCreateDTO.getContentId());
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("el id no tiene formato UUID " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("error encontrando contenido " + e.getMessage());
        }

        Effect effect = new Effect();
        effect.setContent(content);
        effect.setName(effectCreateDTO.getName());
        effect.setDescription(effectCreateDTO.getDescription());
        effect.setConditionEnum(effectCreateDTO.getConditionEnum());
        effect.setDurationValue(effectCreateDTO.getDurationValue());
        effect.setDurationUnit(effectCreateDTO.getDurationUnit());

        try {
            Effect savedEffect = effectService.save(effect);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedEffect);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("error guardando contenido " + e.getMessage());
        }
    }

    @PutMapping
    public Effect update(@RequestBody Effect effect) {
        return effectService.update(effect);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        effectService.deleteById(id);
    }



}
